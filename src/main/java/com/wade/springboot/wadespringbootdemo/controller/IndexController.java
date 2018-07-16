package com.wade.springboot.wadespringbootdemo.controller;

import com.wade.springboot.wadespringbootdemo.service.DataProcessor;
import com.wade.springboot.wadespringbootdemo.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class IndexController {

    @Autowired
    DataProcessor dataProcessor;

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value="/",method= RequestMethod.GET)
    public String index(){

        logger.info("===========================================index ");

        return "index";
    }
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String sayHello(){
        logger.info("===========================================hello ");
        return "hello";
    }

    @RequestMapping(value="/saveData",method= RequestMethod.GET)
    public String saveData(){
        logger.info("===========================================hello ");

        String uuid = UUID.randomUUID().toString();

        User user = new User();
        user.setId("uuid");
        user.setName("zhangsan");

        dataProcessor.addToQueue(user);

        return "hello";
    }


}
