package com.shfc.adviser.ao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fc.common.redis.RedisUtil;
import com.shfc.adviser.utils.HttpSessionUtils;
import com.shfc.adviser.utils.ValidDateUtils;
import com.shfc.adviser.wnl.Util.AstroUtil;
import com.shfc.adviser.wnl.Util.JdwxProperties;
import com.shfc.adviser.wnl.api.DefaultApi;
import com.shfc.adviser.wnl.api.DefaultApiM;
import com.shfc.adviser.wnl.wxlink.ApiException;
import com.shfc.common.base.StringUtils;
import com.shfc.common.base.ValidateHelper;
import com.shfc.common.date.DateUtils;
import com.shfc.common.json.JsonUtils;
import com.shfc.common.result.ResultDO;
import com.shfc.house.dto.RealtorInfoDTO;
import com.shfc.house.service.RealtorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Package com.shfc.adviser.ao.PerpetualAO
 * @Description: TODO
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author wliao
 * @date 2017/1/5 14:24
 * version V1.0.0
 */
@Service
public class PerpetualAO {

    public Logger logger = Logger.getLogger(PerpetualAO.class);

    private final DefaultApi api = new DefaultApi();

    private final DefaultApiM apiInstance = new DefaultApiM();

    private final String appkey = JdwxProperties.getProperties("jdwx.appkey");

    @Autowired
    private RealtorService realtorService;


    /**
     *
     * @param currentDate
     * @return
     */
    public ResultDO<JSONObject> selectWnlJsonStr(String currentDate){
        ResultDO<JSONObject> resultDO = new ResultDO<JSONObject>();
        if(ValidateHelper.isEmpty(currentDate)){
            resultDO.setErrMsg("日期格式错误");
            return resultDO;
        }
        if(!ValidDateUtils.isValidDate(currentDate)){
            resultDO.setErrMsg("日期格式错误");
            return resultDO;
        }
        String wnlStr = StringUtils.toString(RedisUtil.get("wnl_"+currentDate),"");
        if(wnlStr==null || wnlStr.length()==0){
            try {
                wnlStr = api.query2(currentDate,appkey);
                JSONObject object = JsonUtils.parseJavaObject(wnlStr, JSONObject.class);

                if(object == null){
                    resultDO.setErrMsg("json格式错误,请检查请求参数");
                    return resultDO;
                }
                if("10000".equals(object.get("code").toString())){
                    String wnlResult = object.getJSONObject("result").get("result").toString();
                    wnlResult = huangLiControl(wnlResult);
                    JSONObject jsonobject = JSON.parseObject(wnlResult);
                    RedisUtil.set("wnl_"+currentDate,jsonobject);
                    resultDO.setData(jsonobject);
                }else{
                    resultDO.setErrMsg("京东万象接口调用错误，请检查参数");
                    String wnlResult = object.getJSONObject("result").toString();
                    logger.error("Exception:"+wnlResult);
                    return resultDO;
                }
            } catch (ApiException e) {
                logger.error("Exception"+e.getMessage());
                resultDO.setErrMsg("调用京东万象报错,错误信息："+e.getMessage());
                return resultDO;
            }
        }else{
            JSONObject jsonobject = JSON.parseObject(wnlStr);
            resultDO.setData(jsonobject);
        }
        resultDO.setSuccess(true);
        return resultDO;
    }


    public ResultDO<JSONObject> selectStarJsonStr(String currentDate,String astroid){
        ResultDO<JSONObject> resultDO = new ResultDO<JSONObject>();

        if(ValidateHelper.isEmpty(currentDate)){
            resultDO.setErrMsg("日期格式错误");
            resultDO.setSuccess(false);
            return resultDO;
        }
        if(!ValidDateUtils.isValidDate(currentDate)){
            resultDO.setErrMsg("日期格式错误");
            resultDO.setSuccess(false);
            return resultDO;
        }

        if(ValidateHelper.isEmpty(astroid)){
            Long currentRealtorId = HttpSessionUtils.getCurrentRealtorId();
            if(currentRealtorId==null){
                resultDO.setErrMsg("获取当前用户错误!");
                resultDO.setSuccess(false);
                return resultDO;
            }
            RealtorInfoDTO infoDTO = realtorService.showCompleteInfo(currentRealtorId);
            if(ValidateHelper.isEmpty(infoDTO)){//如果经纪人信息不完善 获取当前日期星座ID
                astroid = AstroUtil.QueryAstroCode(DateUtils.getCurrentTime("yyyy-MM-dd"))+"";
            }else{
                String IDCardNo = infoDTO.getIdentityNo();
                if(ValidateHelper.isEmpty(IDCardNo)){//如果身份证为空 获取当前日期的星座ID
                    astroid = AstroUtil.QueryAstroCode(DateUtils.getCurrentTime("yyyy-MM-dd"))+"";
                }else{
                    String year=IDCardNo.substring(6,10);
                    String month=IDCardNo.substring(10,12);
                    String day=IDCardNo.substring(12,14);
                    astroid = AstroUtil.QueryAstroCode(year+"-"+month+"-"+day)+"";
                }
            }

        }

        BigDecimal astroidBig = new BigDecimal(astroid);
        String starStr = StringUtils.toString(RedisUtil.get("star_"+astroid+"_"+currentDate),"");
        if(ValidateHelper.isEmpty(starStr)){//如果redis为空 去京东万象获取星座内容
            try {
                starStr = apiInstance.astro(astroidBig,currentDate,appkey);
                JSONObject object = JsonUtils.parseJavaObject(starStr, JSONObject.class);
                if(object == null){
                    resultDO.setErrMsg("json格式错误,请检查请求参数");
                    return resultDO;
                }
                if("10000".equals(object.get("code").toString())){
                    String starResult = object.getJSONObject("result").get("result").toString();
                    JSONObject jsonobject = JSON.parseObject(starResult);
//                    //如果运势低于3 那就设置成3
//                    int summary = jsonobject.getJSONObject("today").getIntValue("summary");
//                    if(summary<3){
//                        jsonobject.getJSONObject("today").put("summary",3);
//                    }
//                    int money = jsonobject.getJSONObject("today").getIntValue("money");
//                    if(money<3){
//                        jsonobject.getJSONObject("today").put("money",3);
//                    }
//                    int career = jsonobject.getJSONObject("today").getIntValue("career");
//                    if(career<3){
//                        jsonobject.getJSONObject("today").put("career",3);
//                    }
//                    int love = jsonobject.getJSONObject("today").getIntValue("love");
//                    if(love<3){
//                        jsonobject.getJSONObject("today").put("love",3);
//                    }
//                    int health = jsonobject.getJSONObject("today").getIntValue("health");
//                    if(love<3){
//                        jsonobject.getJSONObject("today").put("health",3);
//                    }
                    RedisUtil.set("star_"+astroid+"_"+currentDate,jsonobject);
                    resultDO.setData(jsonobject);
                }else{
                    resultDO.setErrMsg("京东万象接口调用错误，请检查参数");
                    String starResult = object.getJSONObject("result").toString();
                    logger.error("Exception:"+starResult);
                    return resultDO;
                }
            } catch (ApiException e) {
                logger.error("Exception"+e.getMessage());
                resultDO.setSuccess(false);
                resultDO.setErrMsg("调用京东万象错误:"+e.getMessage());
                return resultDO;

            }
        }else{
            JSONObject jsonobject = JSON.parseObject(starStr);
//            //如果运势低于3 那就设置成3
//            int summary = jsonobject.getJSONObject("today").getIntValue("summary");
//            if(summary<3){
//                jsonobject.getJSONObject("today").put("summary",3);
//            }
//            int money = jsonobject.getJSONObject("today").getIntValue("money");
//            if(money<3){
//                jsonobject.getJSONObject("today").put("money",3);
//            }
//            int career = jsonobject.getJSONObject("today").getIntValue("career");
//            if(career<3){
//                jsonobject.getJSONObject("today").put("career",3);
//            }
//            int love = jsonobject.getJSONObject("today").getIntValue("love");
//            if(love<3){
//                jsonobject.getJSONObject("today").put("love",3);
//            }
//            int health = jsonobject.getJSONObject("today").getIntValue("health");
//            if(love<3){
//                jsonobject.getJSONObject("today").put("health",3);
//            }
            resultDO.setData(jsonobject);
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    /**
     * 黄历对照功能
     * @param huangli
     * @return
     */
    public String huangLiControl(String huangli){
        huangli = huangli.replace("祭祀","送礼");
        huangli = huangli.replace("安葬","跳槽");
        huangli = huangli.replace("嫁娶","K歌");
        huangli = huangli.replace("出行","外出");
        huangli = huangli.replace("祈福","取钱");
        huangli = huangli.replace("动土","搭车");
        huangli = huangli.replace("安床","迟到");
        huangli = huangli.replace("开光","减肥");
        huangli = huangli.replace("纳采","收款");
        huangli = huangli.replace("入殓","熬夜");
        huangli = huangli.replace("移徙","租房");
        huangli = huangli.replace("破土","请客");
        huangli = huangli.replace("解除","打扫");
        huangli = huangli.replace("入宅","喝酒");
        huangli = huangli.replace("修造","修车");
        huangli = huangli.replace("栽种","点赞");
        huangli = huangli.replace("开市","加班");
        huangli = huangli.replace("移柩","请假");
        huangli = huangli.replace("订盟","交友");
        huangli = huangli.replace("拆卸","分手");
        huangli = huangli.replace("立卷交易","购物");
        huangli = huangli.replace("求嗣","约会");
        huangli = huangli.replace("上梁","签单");
        huangli = huangli.replace("纳财","借钱");
        huangli = huangli.replace("起基","运动");
        huangli = huangli.replace("斋醮","聊天");
        huangli = huangli.replace("赴任","早起");
        huangli = huangli.replace("冠笄","理发");
        huangli = huangli.replace("安门","自拍");
        huangli = huangli.replace("修坟","回访");
        huangli = huangli.replace("挂匾","中奖");
        return huangli;
    }


    public static void main(String[] args) throws ApiException {
        String appkey = "6765b5345c27f8e2bb5d3a5da2ef9174";
        DefaultApiM apiInstance = new DefaultApiM();
        BigDecimal astroidBig = new BigDecimal("10");
        String currentDate = "2016-12-12";
        //String starStr = apiInstance.astro(astroidBig,currentDate,appkey);
        //System.out.print(starStr);
        String huanli = "{\"code\":\"10000\",\"charge\":false,\"msg\":\"查询成功\",\"result\":{\"msg\":\"ok\",\"result\":{\"astroid\":\"10\",\"astroname\":\"摩羯座\",\"month\":{\"career\":\"上旬和中旬，有想法，但更多是观望看机会。下旬，以为时机已到果断出手，可惜时运不济，空手而返的多。不要沮丧，有一个词叫做“蓄势”。\",\"date\":\"2016-12\",\"health\":\"心情的不佳，会用美食来填满，因此引发身体不适。下旬开启水逆，出行易有意外。\",\"love\":\"在强攻了的一段时间后，摩羯的理智会让你迅速转到一个有利的位置，谋定而动。爱情也是可以算计的，或者很多人觉得“算计”是一个贬义词，但是你不得不承认，这就是人性。\",\"money\":\"上旬理财容易受情绪化影响，下旬又有水逆带来意外破财，因而中旬的运气最佳，建议这个时期要相信自己的分析判断甚至是直觉，迅速把握机会。\",\"summary\":\"面对颓势，你是自己拯救自己的那个人，表面看来，上旬和中旬，你都还是消极应付的状态，但实际在你的头脑里，正在卷起一场思维大风暴，各种点子轮着转，不过这个时期，你的想法很容易被别人影响。下旬，想法会成形，积极将其付诸行动，但不幸的是，刚好遭遇水逆，事情进展出意外多，配合火星此时转宫的能量来看，多和说话不懂顾忌有关。\"},\"today\":{\"career\":\"2\",\"color\":\"橙色\",\"date\":\"2016-12-12\",\"health\":\"4\",\"love\":\"1\",\"money\":\"2\",\"number\":\"3\",\"presummary\":\"最近感情中任何风吹草动都可能会触发你敏感的神经，过去的一些经验再次浮现脑海，让你很想与他人倾诉一番。今天的你优哉游哉不至于过于匆忙，反而能有很不错的思绪出现。\",\"star\":\"天蝎座\",\"summary\":\"1\"},\"tomorrow\":{\"career\":\"1\",\"color\":\"蓝色\",\"date\":\"2016-12-13\",\"health\":\"4\",\"love\":\"1\",\"money\":\"2\",\"number\":\"2\",\"presummary\":\"今日的摩羯要小心犯迷糊情绪，工作上有些茫然的感觉。沟通起来相当吃力，有一些不被认可和理解的感受。然而你也十分关注自身未来的发展，在意在他人眼中的形象。\",\"star\":\"水瓶座\",\"summary\":\"1\"},\"week\":{\"career\":\"本周摩羯人会在职场上发挥领导作用，左右逢源，但同样会承担起很大一部分责任。\\r\",\"date\":\"2017-01-08~01-14\",\"health\":\"本周摩羯人的精神状态逐渐转好。\\r\",\"job\":\"本周摩羯人的高光职场会为摩羯人带来被挖角的可能。\\r\",\"love\":\"本周单身的摩羯人有可能会遇到艺术气息较浓的人，有伴的朋友可能会因为自己的固执伤害到对方，建议多考虑对方的感受。\\r\",\"money\":\"本周摩羯人的财运较差，可能有一些意外的支出。\\r\"},\"year\":{\"career\":\"\\r2016年的事业运很难一面倒地说好或是坏，反而让人有些哭笑不得，因为理想中的事业发展得并不算好，无心插柳用来混日子的事业却能做的不错。土星停留在因果宫内，意味着不是一个适合开展大计划的时间，但木星却停留在与未来与事业有关的宫位，所以你难免对未来会思考很多，但也必须指出很多想法并不符合当前的实际状况，或是你想要做的事情超出了当下的个人能力范围。年初2个月，虽然水星逆行会给你带来一些资金结算上的麻烦，但却瑕不掩瑜，也有机会因为口碑和人脉捞到可观收入。3月9日的双鱼座日食可能引发一些突发状况，容易与合作者因为对前景和规划的不同意见以及资金分账和投入上的分歧而压力巨大，甚至因此分道扬镳。一些重要的计划也可能在3月中旬突然卡壳，必须重新整理文书，沟通细节才可能逐渐改善或是挽回，只有度过5月下旬才勉强算是危机解除。6月底，项目将有望重新启动，生活也看似回到正轨，但此前的危机却会让你对前景更加迷茫，而导致整个夏天都身体俱疲无力奋斗。从9月底开始，因为木星终于移位进入事业宫，水星也趋于正常，你将终于与周围的人和事都达成共识，事业上也将崭露头角。虽然当前的工作也许并非你最看好和想做的，但接受现实也是一种更好的选择。只要从内心认同当前的工作，你会发现这份工作会在年底给你带来丰厚的回报。\\r\",\"date\":\"2016\",\"love\":\"2016年，因为火星会在摩羯座的人际宫位徘徊约4个月时间，也让你们的社交生活变得丰富起来。有趣的是，于摩羯本身而言，很多社交活动并非出于自愿，却不得不为了应付家人、工作需要等种种原因而频繁奔波，并因为个人出色的表现而总能获得异性青睐。但这些桃花多数都只能停留在搭搭讪、聊聊天的程度上，因为你们实在太忙，或是关键时刻总是被别的事情打乱计划而难以有进一步进展，加上自己也一直在与心魔抗争，并没有太多心思投入感情。2月是桃花运最旺的一个月，此时不论是探亲访友还是出门旅行都容易遇到有趣且谈得来的对象，也是最容易受孕的一段时间。但进入3月，日食对已有的恋情会带来不好的影响，注意两人容易因对未来的目标不同而开始有了离心。5月将是今年桃花运最旺的一个月，各种新人旧人一起上阵，让你眼花缭乱应接不暇。有伴者要注意一个处理不好，可能就会给现有的感情关系雪上加霜，甚至走向分手。单身者倒是一切随心，有兴趣者可以继续聊骚，或是更进一步都在掌控之中。5月下旬开始，桃花运将回复平淡，摩羯座自己的心思也开始转移到别的事情上，或是感觉继续做个没有负担的花蝴蝶会更加轻松。此后，从11月中旬到12月上旬，桃花运将逐步回升，想脱单者可以抓紧这段时间继续努力。\",\"money\":\"对大多数摩羯座来说，今年的前三个季度在财运上并没有太多超出预期的表现，基本只能算是循序渐进，偶有意外收获而已。年后是相对而言正财运最好的一个月，部分摩羯座可以拿到数目客观的年终奖金，另一些人则有望因为出色表现而被老板加薪。企业主和自由职业者将比较容易在过年前后接到业务，虽然比较辛苦，但最后的收入应该还算满意。比较需要小心的是3月初的双鱼座月食，可能会给你带来一个需要长线投资的项目，导致手头资金紧张。企业主和自由职业者要小心恶意竞争和恶意收购，上班族出差请记住管好各种收据。进入5月份，一些此前的长线投资有望拿到不错的收益，但此时只宜收钱，不宜追加。6月到9月则是不太利于财运的时段，虽然6月底有望拿到一笔数额不菲的收入，但同时却很容易因为交通、物流、诉讼、电子设备及交通工具而导致莫名其妙的破财，若有意购买汽车和电子设备也最好避开这段时间，否则很有可能买到问题产品，或是后期一直翻修烦不胜烦。10月之后，正财运会开始明显走上坡路，各种零星的奖金、红包也是不断，只要努力就能看到收益，年底前后更是有望实现质的飞跃，足以犒劳一年以来无比疲惫的心。\",\"summary\":\"未来一年对大多数摩羯座而言将继续是表面继续风骚，内心无比彷徨的一年。2016年，命主星土星全年都在因果宫内站岗，意味着人生其实处于一个结束过往积累，辞旧迎新，为下一程出发做准备的时节。但悲剧的是，旧的已经看到结束，新的目标却还是云山雾绕，这会让很多摩羯座忍不住迷茫和困苦。但是勤劳的摩羯们又不可能简单地让自己放松就好，而宁可继续尝试一些也许并不适合自己的事情。虽然内心对当下所做的事情其实并没有太高的认可度，但却因为个人能力出色而继续做得不错，在相关领域也是独领风骚，赚到不少吆喝。只是钱财方面却不算充盈，内心的满足感也从未到达令人满意的程度，苦闷只有打落牙齿肚里吞。但对摩羯座来说，也还是有一些值得高兴的好消息：至少生活方面算是暂时安定了下来，不用再像过去几年那样不断搬家折腾，当下所从事的工作和某些尝试也会让你对人生有了不同的认知。虽然内心的惶惑还会存在，但如果能够变得乐观一些，你就会发现即便不是太喜欢现在的工作或是生活，但一切都在向好发展，经济收入也会随之同步提高。在平淡之时享受生活也是一门重要的必修课。\"}},\"status\":\"0\"}}\n";
        JSONObject object = JsonUtils.parseJavaObject(huanli, JSONObject.class);
        System.out.print(object.getJSONObject("result").get("result"));

    }
}
