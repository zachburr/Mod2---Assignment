package iface;

import java.util.List;
import model.Sale;

/**
 * Defines how classes that create sales reports must behave.
 */
public interface SalesReport {

    /**
     * Generates a report using the supplied list of sales.
     */
    void generateReport(List<Sale> salesList);
}