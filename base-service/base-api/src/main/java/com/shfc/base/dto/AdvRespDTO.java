package com.shfc.base.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 *
 * @author wky
 * @version V1.0
 * @create 2017-06-20 11:16
 **/
public class AdvRespDTO implements Serializable {
    private List<AdvertisementListDTO> bannerlist;

    private List<AdvertisementListDTO> list;

    public List<AdvertisementListDTO> getBannerlist() {
        return bannerlist;
    }

    public void setBannerlist(List<AdvertisementListDTO> bannerlist) {
        this.bannerlist = bannerlist;
    }

    public List<AdvertisementListDTO> getList() {
        return list;
    }

    public void setList(List<AdvertisementListDTO> list) {
        this.list = list;
    }
}
