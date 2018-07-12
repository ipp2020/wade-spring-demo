package com.wade.springboot.wadespringbootdemo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wade.springboot.wadespringbootdemo.vo.User;

public class GsonUtil {

    public static String toJson(Object object) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(object);
    }


    public static void main(String[] args) {

        User user = new User();
        user.setId("1");
        user.setName("zhangsan");

        String json = GsonUtil.toJson(user);
        System.out.println(json);
    }
}
