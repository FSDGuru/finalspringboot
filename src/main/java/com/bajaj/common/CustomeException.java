package com.bajaj.common;

import com.bajaj.beans.ErrorBean;

public class CustomeException extends Exception{

    ErrorBean errorBean;
    public CustomeException(ErrorBean errorBean)
    {
        super(errorBean.getErrorMessage());
        this.errorBean=errorBean;
    }

    public ErrorBean getErrorBean() {
        return errorBean;
    }

    public void setErrorBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
    }

    @Override
    public String toString() {
        return "CustomeException{" +
                "errorBean=" + errorBean +
                '}';
    }
}
