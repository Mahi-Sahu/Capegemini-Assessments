package com.cg.bean;

import org.springframework.stereotype.Component;

@Component("cng")
public class CNGEngine implements IEngine{
    @Override
    public String getBHP(){
        return "Engine: CNG \nBHP: 110 BHP";
    }
}
