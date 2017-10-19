package com.shfc.house.service;

import com.shfc.common.result.ResultDO;

import java.io.IOException;

/**
 * Copyright:Copyright (c) 2017
 * Company:东方金融-上海房产
 *
 * @author xiehb
 * @version V1.0
 * @date 2017/6/7 下午1:56.
 */
public interface ImportDataService {

     ResultDO inportRealtorData(String filePath);

}
