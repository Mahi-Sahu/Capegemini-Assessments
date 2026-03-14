package com.cg.bean;

import org.springframework.stereotype.Component;

@Component("mrf")
public class MRFTyre implements ITyre {
    @Override
    public String getTyreDetails(){
        return "MRF Tyre";
    }
}
