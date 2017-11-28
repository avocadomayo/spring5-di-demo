package ca.wendyliu.didemo.controllers;

import ca.wendyliu.didemo.services.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructorInjectedControllerTest {

    private ConstructorInjectedController constructorInjectedController;

    /** We're passing the dependency into the constructor, hence the name constructor-based dependency injection */
    @Before
    public void setUp() throws Exception {
        this.constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImpl.GREETING_MESSAGE, constructorInjectedController.sayHello());
    }
}
