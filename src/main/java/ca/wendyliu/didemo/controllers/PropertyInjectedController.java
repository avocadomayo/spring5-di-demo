package ca.wendyliu.didemo.controllers;

import ca.wendyliu.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/** BAD EXAMPLE: DO NOT inject with a property. Hard-coded dependency is hard to substitute.
 * Annotating with @Controller makes this class an injectable Spring Bean.
 */
@Controller
public class PropertyInjectedController {

    /**
     * Asks Spring to inject this.
     */
    @Autowired
    @Qualifier("greetingServiceImpl")
    public GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
