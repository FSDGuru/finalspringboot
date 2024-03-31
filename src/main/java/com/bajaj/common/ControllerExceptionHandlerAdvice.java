package com.bajaj.common;

import com.bajaj.beans.ErrorBean;
import com.bajaj.beans.ResponseBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandlerAdvice {
@ExceptionHandler
    public ResponseEntity<ResponseBean> catchRuntimeException(Exception ex) {
        System.out.println("*****Exception*****");

        if (ex instanceof CustomeException) {
            CustomeException customeException = (CustomeException) ex;
            ResponseEntity<ResponseBean> responseEntity = null;
            ResponseBean responseBean = new ResponseBean();
            List<ErrorBean> listOfErrorBean = new ArrayList<>();
            listOfErrorBean.add(customeException.getErrorBean());
            responseBean.setErrorBean(listOfErrorBean);
            responseEntity = new ResponseEntity<>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
            return responseEntity;
        }

        ResponseEntity<ResponseBean> responseEntity = null;
        ResponseBean responseBean = new ResponseBean();
        ErrorBean errorBean = new ErrorBean();
        errorBean.setErrorCode("Exception");
        errorBean.setErrorMessage(ex.getMessage());
        List<ErrorBean> listOfErrorBean = new ArrayList<>();
        listOfErrorBean.add(errorBean);
        responseBean.setErrorBean(listOfErrorBean);
        responseEntity = new ResponseEntity<>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

}
