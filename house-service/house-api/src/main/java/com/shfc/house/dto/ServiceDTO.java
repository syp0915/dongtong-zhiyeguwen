package com.shfc.house.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * 增值服务DTO
 *
 * @author wky
 * @version V1.0
 * @create 2017-07-11 15:02
 **/

public class ServiceDTO implements Serializable {

    private Long serviceId;//服务id

    private String serviceName;//服务名称

    private String serviceType;//服务类型

    private Long comId;//所属公司Id

    private String comName;//所属公司名称

    private String serviceDetail;//服务内容介绍


    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail;
    }
}
