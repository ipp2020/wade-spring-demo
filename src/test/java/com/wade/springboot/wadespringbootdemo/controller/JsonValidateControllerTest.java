package com.wade.springboot.wadespringbootdemo.controller;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;


public class JsonValidateControllerTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void index() {

        Gson gson = new Gson();
        RequestCodeDTO requestCodeDTO =  gson.fromJson("{code1223:\"123\"}", RequestCodeDTO.class);
        System.out.println(requestCodeDTO.getCode());
    }

    class RequestCodeDTO {
        String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

}