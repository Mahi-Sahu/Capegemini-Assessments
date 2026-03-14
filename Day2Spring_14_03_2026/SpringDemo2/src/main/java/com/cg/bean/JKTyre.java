package com.cg.bean;

import org.springframework.stereotype.Component;

@Component("jk")
public class JKTyre implements ITyre{
    @Override
    public String getTyreDetails(){
        return "JK Tyre";
    }
}
