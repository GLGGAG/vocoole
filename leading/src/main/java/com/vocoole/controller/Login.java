package com.vocoole.controller;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GLGGAG
 * @date 2018-04-04 11:23
 * @Description:
 */
@RestController
public class Login {


    @RequestMapping("hello")
    public String hello(){
        return "hello world";
    }

}
