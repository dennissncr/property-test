package com.propertytest.PropertyTest.config;


import com.propertytest.PropertyTest.service.DefaultGreeting;
import org.example.hello.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class BeanConfig {

    public Hello helloBean(){
        return new DefaultGreeting();
    }
}
