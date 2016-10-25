package com.muran.mrshop.data;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/7.
 */
public class OrderStatus implements Serializable {
    private Integer status;
    private String statusDes;

    public OrderStatus(){};
    public OrderStatus(Integer status, String statusDes) {
        this.status = status;
        this.statusDes = statusDes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDes() {
        return statusDes;
    }

    public void setStatusDes(String statusDes) {
        this.statusDes = statusDes;
    }
}
