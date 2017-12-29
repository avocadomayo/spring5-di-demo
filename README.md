## Manual Dependency Injection without Spring
### How to access H2 database console
0. Go to localhost:<port>/h2-console
0. Enter JDBC URL `jdbc:h2:mem:testdb`
0. Enter User `sa`

### Correct ways to do it:
0. Constructor-based dependency injection (preferred since it requires the dependency to be injected when class is instantiated)
0. Setter-based dependency injection (easier to mess up)
0. Property-based injection (BAD)

Note: you should always use interfaces instead of concrete classes for injection, so that the implementation could be determined by the runtime environment.

### DI with Spring
0. Annotating with `@Service`, `@Controller` makes class available to Spring Context as a Spring Bean.
0. Use `@Autowired` to have the Spring Context automatically inject a Bean.
0. Use @Qualifier("greetingServiceImpl") to specify a Bean you want to inject by name.
0. When there are multiple Bean candidates to inject, we can mark the primary choice by annotating dependency with `@Primary`.
0. Use any of `@Component`, `@Service`, `@Controller`, or `@Repository` to trigger Spring Context to bring it in as a Bean.

### Spring Profiles
- A set of configurations applied at runtime.
- Available in resources/application.properties: spring.profiles.active=<profile_name_here>
- Default Profile: active when we don't explicitly specify a Spring Profile. We can configure the default profile such that when there is no candidate Bean to inject, we fallback onto the default Bean.
    - `application-default.properties` or `application-default.yml`
    -  We can mark a Bean to be included into the default profile (and en profile in this example) by `@Profile({"en", "default"})`.
    - Only active when no other profile is active.

### Manipulating Bean Lifecylce
- Can implement interfaces InitializingBean and DisposableBean to tap into the Bean lifecycle.
- Use @PostConstruct and `@PreDestroy` to access the Spring Bean lifecycle.

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
- In Java config, use `@Scope`
- In XML, `scope` is an XML attribute of `<bean>`

No declaration needed for Singleton scope.

### External Configuration
- [Hierarchy of who overrides what](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)
- Able to create profile-specific config files, by naming them `application-<profile name>.properties`.
    - Eg. `application-de.properties` for this code demo

### Tools
- Use TCPMON to inspect REST API communication from within IntelliJ
- Use [Spring Boot Development Tools](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html) (In IntelliJ macOS, Cmd + F9 to very quickly rebuild)

---

### JPA
- Can inherit from a super class
- Can have an embedded object

### JPA Entity Relationships
- `@OneToOne`
- `@OneToMany` (foreign key typically in 'Many' side)
    - Ownership determined by `mappedBy` attribute
- `@ManyToOne` (foreign key typically in 'Many' side)
- `@ManyToMany`
    - Eg. Many products belonging to many categories and vice-versa
    - Requires use of a join table

### JPA Fetch Types
- Lazy Fetch: data not queried until referenced
- Eager Fetch: data queried upfront

### JPA Cascade Types
Controls how changes are cascaded from parent obj to child obj. In JPA 2.1, there is no default cascade type.
In JPA 2.1, the 6 available cascade types are:
- `PERSIST`
- `MERGE`
- `REFRESH`
- `REMOVE`
- `DETACH`
- `ALL`

### Lob, Clobs, Blobs
- Large Objects, Large Character Objects, Large Binary Objects
- Use `@Lob` annotation, JPA will expect to store a large object

### Spring JDBC
- Initializing with Hibernate: data will be loaded from `import.sql`
    - Hibernate feature (not Spring-specific)
    - Must be on root of classpath
    - Only executed if Hibernate's DDL-auto property is set to `create` or `create-drop`
- Spring DataSource Initializer via Spring Boot will by default load `schema.sql` and `data.sql` from the root of the classpath
    - Will auto auto-load from `schema-${platform}.sql` and `data-${platform}.sql` but you must set `spring.datasource.platform` in `application.properties`
- May conflict with Hibernate's DDL Auto property. Use one if you can.

### Spring Data JPA Query Methods
- We can simply define a method in a Repository interface, and Spring will generate the implementation! These are called Query Methods.

---

### RESTful Web Services
- Use [RestTemplate](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html) to perform synchronous client-side HTTP operations.
- Provide it as a `@Bean` by creating a `@Configuration` class that returns a `RestTemplate`. It can be constructed by calling RestTemplateBuilder#build().
- Neat tool [Fruit Shop API](https://api.predic8.de/shop/docs) - open API for playing

### MapStruct
- Code generator for Java bean mapping. Helps reduce coding for type conversions
- When dealing with REST services, we commonly expose API data through DTOs (Data Transfer Object.)
- You'll declare interfaces and MapStruct will generate code at build time.
