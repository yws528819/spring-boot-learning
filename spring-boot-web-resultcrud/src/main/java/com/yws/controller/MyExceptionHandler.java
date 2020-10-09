package com.yws.controller;

import com.yws.exception.UserNoExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //浏览器、客户端返回的都是jsons
//    @ExceptionHandler(UserNoExistsException.class)
//    @ResponseBody
//    public Map<String, Object> handleException(Exception e){
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("code", "user.noexist");
//        map.put("message", e.getMessage());
//        return map;
//    }


    @ExceptionHandler(UserNoExistsException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        //传入我们自己的错误码 4xx 5xx
        request.setAttribute("javax.servlet.error.status_code", 500);

        map.put("code", "user.noexist");
        map.put("message", "用户出错啦");

        return "forward:/error";
    }
}
