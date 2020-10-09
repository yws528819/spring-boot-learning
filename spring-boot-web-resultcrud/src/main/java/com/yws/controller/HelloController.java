package com.yws.controller;

import com.yws.exception.UserNoExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("user") String user) {
        if ("aaa".equals(user)) {
            throw new UserNoExistsException();
        }
        return "hello,World!";
    }


    @GetMapping("/toSuccess")
    public String success(Map<String,Object> map) {
        map.put("hello", "<h1>你好！</h1>");
        map.put("users", Arrays.asList("张三", "李四", "王五"));
        return "success";
    }
}
