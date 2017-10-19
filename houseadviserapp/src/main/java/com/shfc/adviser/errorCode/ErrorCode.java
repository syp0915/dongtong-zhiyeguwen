package com.shfc.adviser.errorCode;

/**
 * @Package com.shfc.adviser.errorCode.ErrorCode
 * @Description: 错误编码
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/1/20 10:34
 * version V1.0.0
 */
public interface ErrorCode {

    /**
     * 账户已解约
     */
    int  ACCOUNT_TERMINATION = -98;

    /**
     * 未登录
     */
    int UN_LOGIN= -99;

    /**
     * 协议id不能为空
     */
    int NOTNULL_PROTOCOL_ID = -30000;

    /**
     * 日期格式错误
     */
    int ERROR_DATE_FORMAT = -30001;

    /**
     * json格式错误,请检查请求参数
     */
    int ERROR_JSON_FORMAT = -30002;

    /**
     * 京东万象接口调用错误，请检查参数
     */
    int ERROR_JDVIENTIANE_INTERFACE_TRANSFER = -30003;

    /**
     *获取当前用户错误
     */
    int ERROR_GET_USER = -30004;

    /**
     * 小区id不能为空
     */
    int NOTNULL_PLOT_ID = -40000;

    /**
     * 楼栋号不能为空
     */
    int NOTNULL_UNIT_NO = -40001;

    /**
     * 门牌号不能为空
     */
    int NOTNULL_ROOM_NO = -40002;

    /**
     * 二手房id不能为空
     */
    int NOTNULL_ID = -40003;

    /**
     * 名称或地址不能为空
     */
    int NOTNULL_PLOTNAME_OR_PLOTADDRESS = -40004;

    /**
     * 经纬度不能为空
     */
    int NOTNULL_LONGITUDE_OR_LATITUDE = -40005;

    /**
     * 小区id不存在
     */
    int NOT_EXIST_PLOT_ID = -40006;

    /**
     * 小区楼栋id不存在
     */
    int NOT_EXIST_UNIT_NO = -40007;

    /**
     * 手机号不能为空！
     */
    int NOTNULL_PHONE = -50000;

    /**
     * 姓名不能为空！
     */
    int NOTNULL_REALNAME = -50001;

    /**
     * 门店代码不能为空！
     */
    int NOTNULL_STORECODE = -50002;

    /**
     * 身份证不能为空！
     */
    int NOTNULL_IDENTITYNO = -50003;

    /**
     * 职位不能为空！
     */
    int NOTNULL_POSITION = -50004;

    /**
     * 主营楼盘不能为空！
     */
    int NOTNULL_BUILDINGNAMELIST = -50005;

    /**
     * 门店代码不正确！
     */
    int NOT_CORRECT_STORECODE = -50006;

    /**
     * 经纪人头像不能为空！
     */
    int NOTNULL_HEADPORTRAIT = -50007;

    /**
     * 经纪人名片不能为空！
     */
    int NOTNULL_CARDIMG = -50008;

    /**
     * 消息类型不能为空！
     */
    int NOTNULL_MESSAGE_TYPE = -50009;

    /**
     * 强制升级到
     */
    int FORCE_UPDATE_TO_3_0_0 = -9999;
}
