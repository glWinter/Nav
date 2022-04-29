package com.winter.navdemo.bean;

public class BaseResponse<T> {
    public String errorMsg;
    public int errorCode;
    public T data;
}
