package com.cg.bean;

import org.springframework.stereotype.Component;

@Component("petrol")
public class PetrolEngine implements IEngine {
    @Override
    public String getBHP(){
        return "Engine: Petrol Engine \nBHP: 150 BHP";
    }
}
