package com.ftq.webpage.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private int code;       //响应状态码
    private String msg;     //响应信息
    private Object data;    //响应数据体
}
