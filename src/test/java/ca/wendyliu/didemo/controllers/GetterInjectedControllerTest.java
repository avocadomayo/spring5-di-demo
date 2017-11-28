package ca.wendyliu.didemo.controllers;

import ca.wendyliu.didemo.services.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetterInjectedControllerTest {

    private GetterInjectedController getterInjectedController;

    /** We pretend to be the Spring Framework. We set GreetingService in setUp() - hence this is called setter-based
     * dependency injection.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        this.getterInjectedController = new GetterInjectedController();
        this.getterInjectedController.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImpl.GREETING_MESSAGE, getterInjectedController.sayHello());
    }
}
