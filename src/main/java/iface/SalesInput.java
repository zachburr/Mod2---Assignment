package iface;

import java.util.List;
import model.Sale;

/**
 * Defines how a class that provides sales data must behave.
 */
public interface SalesInput {

    /**
     * Returns a list of sales for the application to process.
     */
    List<Sale> getSales();
}