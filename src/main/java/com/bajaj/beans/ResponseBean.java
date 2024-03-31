package com.bajaj.beans;

import java.util.List;

public class ResponseBean {
    Object payload;
    List<ErrorBean> errorBean;

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public List<ErrorBean> getErrorBean() {
        return errorBean;
    }

    public void setErrorBean(List<ErrorBean> errorBean) {
        this.errorBean = errorBean;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "payload='" + payload + '\'' +
                ", errorBean=" + errorBean +
                '}';
    }
}
