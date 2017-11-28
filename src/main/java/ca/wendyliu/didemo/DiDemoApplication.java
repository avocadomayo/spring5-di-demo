package ca.wendyliu.didemo;

import ca.wendyliu.didemo.controllers.ConstructorInjectedController;
import ca.wendyliu.didemo.controllers.GetterInjectedController;
import ca.wendyliu.didemo.controllers.MyController;
import ca.wendyliu.didemo.controllers.PropertyInjectedController;
import ca.wendyliu.didemo.examplebeans.FakeDataSource;
import ca.wendyliu.didemo.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * This annotation indicates Spring Boot will do a component scan from this directory & under.
 */
@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DiDemoApplication.class, args);

		// Lookup Bean by class name, but with the first character lowercase
		MyController controller = (MyController) context.getBean("myController");

        FakeDataSource fakeDataSource = context.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUser());

        FakeJmsBroker fakeJmsBroker = context.getBean(FakeJmsBroker.class);
        System.out.println(fakeJmsBroker.getUser());

		// Dependency injection experiments below:
/*		System.out.println("MyController: " + controller.hello());
		System.out.println("PropertyInjectedController: " +
                context.getBean(PropertyInjectedController.class).sayHello());
		System.out.println("GetterInjectedController: " + context.getBean(GetterInjectedController.class).sayHello());
		System.out.println("ConstructorInjectedController: " +
                context.getBean(ConstructorInjectedController.class).sayHello());*/
	}
}
