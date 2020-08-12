package com.ftq.webpage.result;

public class Result {
    //响应码
    private int code;


    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code){
        this.code = code;
    }
}
