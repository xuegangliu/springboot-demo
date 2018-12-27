package com.lxg.sample.exception;

/**
 * Created by 刘雪岗 on 2017/1/4.
 * 自定义异常类
 */
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
