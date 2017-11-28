package ca.wendyliu.didemo.services;

import org.springframework.stereotype.Service;

/** Marked as a Spring component, picked up by Spring Context */
@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String GREETING_MESSAGE = "Hello Vancouver! (Original)";

    @Override
    public String sayGreeting() {
        return GREETING_MESSAGE;
    }
}
