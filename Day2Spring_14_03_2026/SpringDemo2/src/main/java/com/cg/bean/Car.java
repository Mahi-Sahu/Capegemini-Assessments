package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component //creates object automatically- stereotyping
@Service //or @Repository or @Controller ->all are the types of @Component
public class Car {
    @Value("${carName}")//looks for properties file and assign carName
    private String name;
    @Autowired
    @Qualifier("petrol")
    private IEngine engine;
    @Autowired
    @Qualifier("mrf")
    private ITyre tyre;
    public Car() {}

    public Car(IEngine engine,ITyre tyre) {
        this.engine = engine;
        this.tyre = tyre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  IEngine getEngine() {
        return engine;
    }

    public void setEngine(IEngine engine) {
        this.engine = engine;
    }

    public ITyre getMrfTyre() {
        return tyre;
    }

    public void setTyre(ITyre tyre) {
        this.tyre = tyre;
    }

    public void printCar(){
        System.out.println("Car name: " + name+ "\n"+engine.getBHP()+ "\nTyre Details: "+tyre.getTyreDetails());
    }
}
