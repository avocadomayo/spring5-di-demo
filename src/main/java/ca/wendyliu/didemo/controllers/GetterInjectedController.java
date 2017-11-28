package ca.wendyliu.didemo.controllers;

import ca.wendyliu.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Annotating with @Controller makes this a Bean and allows Spring Context to manage it.
 */
@Controller
public class GetterInjectedController {

    private GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }

    /**
     *
     * @param greetingService
     */
    @Autowired
    @Qualifier("getterGreetingService")
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
