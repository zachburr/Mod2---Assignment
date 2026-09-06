package impl;

import iface.SalesReport;
import model.Sale;

import java.util.List;

/**
 * Displays every individual sale in the report.
 */
public class DetailReport implements SalesReport {

    @Override
    public void generateReport(List<Sale> salesList) {

        // Prints the report title.
        System.out.println("SALES DETAIL REPORT");

        // Prints the column headings with formatting.
        System.out.printf(
                "%-30s %-18s %8s %8s %10s%n",
                "Customer",
                "Country",
                "Amount",
                "Tax",
                "Shipping"
        );

        // Prints one row for every sale in the list.
        for (Sale sale : salesList) {

            System.out.printf(
                    "%-30s %-18s %8.2f %8.2f %10.2f%n",
                    sale.getCustomer(),
                    sale.getCountry(),
                    sale.getAmount(),
                    sale.getTax(),
                    sale.getShipping()
            );
        }
    }
}