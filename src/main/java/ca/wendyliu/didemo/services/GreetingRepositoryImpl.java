package ca.wendyliu.didemo.services;

import org.springframework.stereotype.Component;

@Component
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String getEnglishGreeting() {
        return "Hello from Canada!";
    }

    @Override
    public String getSpanishGreeting() {
        return "Hello from Spain!";
    }

    @Override
    public String getGermanGreeting() {
        return "Hallo von Deutschland!";
    }
}
