package com.ftq.webpage.result;

public class ResultFactory {

    public static Result buildSuccessResult(Object data) {
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }

    public static Result buildFailResult(String msg) {
        return buildResult(ResultCode.FAIL, msg, null);
    }

    public static Result buildResult(ResultCode resultCode, String msg, Object data) {
        return buildResult(resultCode.code, msg, data);
    }

    public static Result buildResult(int code, String msg, Object data) {
        return new Result(code, msg, data);
    }

}
