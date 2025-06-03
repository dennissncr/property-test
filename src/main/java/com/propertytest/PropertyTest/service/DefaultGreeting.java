package com.propertytest.PropertyTest.service;

import org.example.hello.Hello;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnMissingBean(value = Hello.class, ignored = DefaultGreeting.class)
public class DefaultGreeting implements Hello {

    @Value( "${messages.default-greeting}" )
    private String greetingMessage;

    @Override
    public String helloMessage() {
        return greetingMessage;
    }
}
