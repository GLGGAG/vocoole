package com.vocoole.foundation.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author GLGGAG
 * @date 2018-04-04 15:34
 * @Description:
 */
@Getter
@Setter
@ToString
public class BaseDo {

    private Date updateTime;
    private Date createTime;
    private int  version;
    private byte deleted;

}
