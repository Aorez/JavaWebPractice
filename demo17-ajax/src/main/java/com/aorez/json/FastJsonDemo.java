package com.aorez.json;

import com.alibaba.fastjson.JSON;

public class FastJsonDemo {
    public static void main(String[] args) {

        //java对象转json字符串
        User user = new User();
        user.setId(1);
        user.setUsername("张");
        user.setPassword("123");
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);

        //json字符串还原为java对象
        User u = JSON.parseObject(jsonString, User.class);
        System.out.println(u);
    }
}
