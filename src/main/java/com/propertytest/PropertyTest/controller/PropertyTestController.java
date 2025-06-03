package com.propertytest.PropertyTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.example.hello.Hello;

@Controller
public class PropertyTestController {

 //   @Value( "${messages.default-greeting}")
    private String greetingMessage;

    @Autowired
    Hello helloService;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    //check for cookie for access token
    //if cookie not present respond with status 401, dxp login url and sm callback url
    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        System.out.println("Inside greet");
        System.out.println("default greeting: "+greetingMessage);
        System.out.println("class "+helloService.getClass().getName());
        try {
            return new ResponseEntity<String>(helloService.helloMessage(), HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Error in helloService.helloMessage(): " + e.getMessage());
            return new ResponseEntity<String>("An error occurred while processing your request.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
