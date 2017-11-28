package ca.wendyliu.didemo.controllers;

import ca.wendyliu.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/** Makes it a Spring component managed by the Spring Context */
@Controller
public class MyController {

    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello() {
        System.out.println("I am MyController.");
        return greetingService.sayGreeting();
    }
}
