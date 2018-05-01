package com.vocoole.support.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author GLGGAG
 * @date 2018-04-04 10:41
 * @Description:
 * 前端json交换消息承载体
 */
@Getter
@Setter
@ToString
public class RespMsg<T> extends Message{


    private static final long serialVersionUID = 1L;

    private String msg;

    private int code;

    private T data;


    public RespMsg(String msg,int code){
        super();
        this.msg = msg;
        this.code = code;
    }


    public RespMsg(String msg, int code,T data) {
        this(msg,code);
        this.data = data;
    }



}
