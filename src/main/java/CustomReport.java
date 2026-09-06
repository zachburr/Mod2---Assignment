import iface.SalesInput;
import iface.SalesReport;
import iface.ShippingPolicy;
import model.Sale;

import java.util.List;

/**
 * Coordinates the steps needed to create a sales report.
 */
public class CustomReport {

    // Provides the sales data.
    private final SalesInput salesInput;

    // Determines how shipping is calculated.
    private final ShippingPolicy shippingPolicy;

    // Determines how the final report is displayed.
    private final SalesReport salesReport;

    /**
     * Receives the three parts needed to create a report.
     * Different implementations can be passed in without changing this class.
     */
    public CustomReport(
            SalesInput salesInput,
            ShippingPolicy shippingPolicy,
            SalesReport salesReport
    ) {
        this.salesInput = salesInput;
        this.shippingPolicy = shippingPolicy;
        this.salesReport = salesReport;
    }

    /**
     * Gets the sales, calculates tax and shipping,
     * and sends the finished sales to the selected report.
     */
    public void generateReport() {

        // Gets all sales from whichever SalesInput implementation was selected.
        List<Sale> sales = salesInput.getSales();

        // Processes each sale before creating the report.
        for (Sale sale : sales) {

            // United States sales use a 5.5% tax rate.
            // All other countries use a 9.5% tax rate.
            double taxRate =
                    "United States".equals(sale.getCountry()) ? 0.055 : 0.095;

            // Calculates the tax and rounds it to two decimal places.
            sale.setTax(
                    Math.round(sale.getAmount() * taxRate * 100.0) / 100.0
            );

            // Uses the selected shipping policy to calculate shipping.
            shippingPolicy.applyShipping(sale);
        }

        // Sends the completed sales data to the selected report type.
        salesReport.generateReport(sales);
    }
}