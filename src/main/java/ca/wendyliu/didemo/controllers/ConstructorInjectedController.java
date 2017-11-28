package ca.wendyliu.didemo.controllers;

import ca.wendyliu.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Preferred method for dependency injection.
 * Annotating with @Controller makes this a Bean and allows Spring Context to manage it.
 */
@Controller
public class ConstructorInjectedController {

    /** Don't need @Autowired. Spring enables automatic wiring of constructor-based DI. */
    private GreetingService greetingService;

    /** Annotation takes in the Bean name, where first letter is lowercase */
    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
