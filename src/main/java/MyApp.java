
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Starts the application using Spring configuration.
 */
public class MyApp {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CustomReport report = context.getBean(CustomReport.class);
        report.generateReport();
    }
}
