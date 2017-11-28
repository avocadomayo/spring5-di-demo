## Manual Dependency Injection without Spring
### Correct ways to do it:
0. Constructor-based dependency injection (preferred since it requires the dependency to be injected when class is instantiated)
0. Setter-based dependency injection (easier to mess up)
0. Property-based injection (BAD)

Note: you should always use interfaces instead of concrete classes for injection, so that the implementation could be determined by the runtime environment.

### DI with Spring
0. Annotating with ```@Service```, ```@Controller``` makes class available to Spring Context as a Spring Bean.
0. Use @Autowired to have the Spring Context automatically inject a Bean. 
0. Use @Qualifier("greetingServiceImpl") to specify a Bean you want to inject by name.
0. When there are multiple Bean candidates to inject, we can mark the primary choice by annotating dependency with ```@Primary```.
0. Use any of ```@Component```, ```@Service```, ```@Controller```, or ```@Repository``` to trigger Spring Context to bring it in as a Bean. 

### Spring Profiles
- A set of configurations applied at runtime.
- Available in resources/application.properties: spring.profiles.active=<profile_name_here>
- Default Profile: active when we don't explicitly specify a Spring Profile. We can configure the default profile such that when there is no candidate Bean to inject, we fallback onto the default Bean.
    -  We can mark a Bean to be included into the default profile (and en profile in this example) by ```@Profile({"en", "default"})```.
    - Only active when no other profile is active.

### Manipulating Bean Lifecylce
- Can implement interfaces InitializingBean and DisposableBean to tap into the Bean lifecycle.
- Use @PostConstruct and ```@PreDestroy``` to access the Spring Bean lifecycle.

### Spring Boot Configurations
(Terminal) show detailed Spring Boot program options
```
mvn spring-boot:help -Ddetail=true
```

(Terminal) run Spring Boot app with debug to see app's auto configurations.
```
mvn spring-boot:run -Ddebug
```
Alternatively, go to Run Configurations in IntelliJ and [x] Enable debug output to see app's auto configurations.

### Spring Bean Scopes
- Singleton (default)
- Prototype: A new instance created each time Bean is requested
- Request: A single instance per http request. Only valid in context of a web-aware Spring ApplicationContext
- Session: A single instance per http session. Only valid in context of a web-aware Spring ApplicationContext
- Global-session: A single instance per global session (mostly legacy)
- Application: Bean is scoped to the lifecycle of a ServletContext. Only valid in context of a web aware
- Websocket: Scoped to the lifecycle of a Websocket. Only in valid context of a web aware

To declare a Bean scope,
- In Java config, use ```@Scope```
- In XML, ```scope``` is an XML attribute of ```<bean>```

No declaration needed for Singleton scope.
