package com.vocoole.support.message;

/**
 * @author GLGGAG
 * @date 2018-04-04 10:27
 * @Description: 前端json错误消息响应格式
 */
public enum  ErrorMsg {

    SUCCESS            (1,"成功"),
    ERROR                 (0,"失败");

    private int  code;

    private String msg;

    ErrorMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
