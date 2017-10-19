package com.shfc.house.service;

import com.shfc.common.result.ResultDO;
import com.shfc.house.httpbean.resp.*;
import com.shfc.house.httpbean.req.*;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author ljgllxyz
 * @version V1.0
 * @date 2017/1/10 上午9:58.
 */
public interface EntrustService {

    /**
     * 根据用户id获取用户委托协议列表
     * @param reqBean60101
     * @return
     */
    public ResultDO<RespBean60101> getEntrustListByUserId(ReqBean60101 reqBean60101);

    /**
     * 根据协议id获取协议详情
     * @param reqBean60102
     * @return
     */
    public ResultDO<RespBean60102> getEntrustInfoById(ReqBean60102 reqBean60102);

    /**
     * 提交撤销指定委托协议
     * @param reqBean60103
     * @return
     */
    public ResultDO<RespBean60103> revokeEntrustById(ReqBean60103 reqBean60103);

    /**
     * 获取指定委托协议状态列表
     * @param reqBean60102
     * @return
     */
    public ResultDO<RespBean60104> getEntrustStatusListById(ReqBean60102 reqBean60102);


    /**
     * 协议签订提交
     * @param reqBean60106
     * @return
     */
    public ResultDO<RespBean60106> submitEntrust(ReqBean60106 reqBean60106);

}
