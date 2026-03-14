package com.cg.cfg;

import com.cg.bean.Address;
import com.cg.bean.Employee;
import com.cg.bean.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class javaConfig {
    @Bean("h")
//    @Scope("prototype")-> makes different objects each time
    public HelloWorld getBean(){
        HelloWorld h=new HelloWorld();
        h.setName("Mahi");
        return h;
    }

    @Bean
    public Employee getBean1(){
        Employee e=new Employee();
        return e;
    }

    @Bean
    public Address getBean2(){
        Address a=new Address();
        return a;
    }
}
