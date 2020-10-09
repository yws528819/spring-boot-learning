package com.yws.exception;

public class UserNoExistsException extends RuntimeException{
    public UserNoExistsException() {
        super("用户不存在");
    }
}
