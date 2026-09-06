import iface.SalesInput;
import iface.SalesReport;
import iface.ShippingPolicy;
import impl.DetailReport;
import impl.SalesInputConsole;
import impl.ShippingDomestic;
import impl.SummaryReport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures which implementations Spring should use for the application.
 */
@Configuration
public class AppConfig {

    /**
     * Tells Spring which SalesInput implementation should be used.
     */
    @Bean
    public SalesInput salesInput() {
        return new SalesInputConsole();
    }

    /**
     * Tells Spring which ShippingPolicy implementation should be used.
     */
    @Bean
    public ShippingPolicy shippingPolicy() {
        return new ShippingDomestic();
    }

    /**
     * Tells Spring which SalesReport implementation should be used.
     */
    @Bean
    public SalesReport salesReport() {
        return new DetailReport();
    }

    /**
     * Creates the CustomReport bean.
     *
     * Spring automatically supplies the SalesInput,
     * ShippingPolicy, and SalesReport beans defined above.
     */
    @Bean
    public CustomReport customReport(
            SalesInput salesInput,
            ShippingPolicy shippingPolicy,
            SalesReport salesReport
    ) {
        return new CustomReport(
                salesInput,
                shippingPolicy,
                salesReport
        );
    }
}