package com.bajaj.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.bajaj.beans.*;
import com.bajaj.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
@Autowired
    UserServiceImpl userService;
    @GetMapping(value = "getemployee", path = "getemployee")
    public ResponseBean getEmployee(@RequestParam Long id) {
  ResponseBean responseBean = new ResponseBean();
        responseBean.setPayload("Success");
        return responseBean;

    }

    @PostMapping(value="login", path = "login")
    public ResponseBean login(@RequestBody @Valid LoginRequestBean requestBean) {
        ResponseBean responseBean = new ResponseBean();
        try {
            responseBean.setPayload( userService.getUser(requestBean));

        }catch ( Exception e)
        {
            ErrorBean errorBean=new ErrorBean();
            errorBean.setErrorCode("000");
            errorBean.setErrorMessage(e.getMessage());
            List<ErrorBean> list=new ArrayList<>();
            list.add(errorBean);
            responseBean.setErrorBean(list);
        }
        return responseBean;

    }


    @PostMapping(value="register", path = "register")
    public ResponseBean signUp(@RequestBody @Valid SignUpRequestBean requestBean) {
        ResponseBean responseBean = new ResponseBean();
        try {

            responseBean.setPayload( userService.saveUser(requestBean));

        }catch (Exception e)
        {
            ErrorBean errorBean=new ErrorBean();
            errorBean.setErrorCode("000");
            errorBean.setErrorMessage(e.getMessage());
            List<ErrorBean> list=new ArrayList<>();
            list.add(errorBean);
            responseBean.setErrorBean(list);
        }
        return responseBean;
    }
}
