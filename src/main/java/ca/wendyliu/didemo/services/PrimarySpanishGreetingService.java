package ca.wendyliu.didemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * With Spring we can create multiple runtime Profiles for an app. A Profile includes a set of configurations,
 * for example, app language, and which database we want to connect to ie. H2 or MySQL. In this example, we create
 * a Spanish Profile for our simple console app, by annotating it as @Profile("es").
 * These configs have been refactored into {@link ca.wendyliu.didemo.config.GreetingServiceConfig}.
 */
//@Service
//@Profile("es")
//@Primary
public class PrimarySpanishGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public PrimarySpanishGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getSpanishGreeting();
    }
}
