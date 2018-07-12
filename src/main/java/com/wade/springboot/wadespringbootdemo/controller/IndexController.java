package com.wade.springboot.wadespringbootdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
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


}
