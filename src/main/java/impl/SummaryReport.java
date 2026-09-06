package impl;

import iface.SalesReport;
import model.Sale;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Groups sales by country and displays totals for each country.
 */
public class SummaryReport implements SalesReport {

    /**
     * Stores the running amount, tax, and shipping totals
     * for one country.
     */
    static class Totals {
        double amount;
        double tax;
        double shipping;
    }

    @Override
    public void generateReport(List<Sale> salesList) {

        /*
         * Stores each country along with its totals.
         *
         * The String is the country name.
         * Totals stores that country's amount, tax, and shipping totals.
         */
        Map<String, Totals> byCountry = new LinkedHashMap<>();

        // Goes through every sale and adds it to its country's totals.
        for (Sale sale : salesList) {

            /*
             * Finds the totals for this country.
             * If the country is not already in the map,
             * a new Totals object is created for it.
             */
            Totals totals = byCountry.computeIfAbsent(
                    sale.getCountry(),
                    country -> new Totals()
            );

            // Adds this sale's values to the country's running totals.
            totals.amount += sale.getAmount();
            totals.tax += sale.getTax();
            totals.shipping += sale.getShipping();
        }

        System.out.println("SALES SUMMARY REPORT");

        System.out.printf(
                "%-18s %8s %8s %10s%n",
                "Country",
                "Amount",
                "Tax",
                "Shipping"
        );

        // Goes through each country and prints its totals.
        for (Map.Entry<String, Totals> entry : byCountry.entrySet()) {

            Totals totals = entry.getValue();

            System.out.printf(
                    "%-18s %8.2f %8.2f %10.2f%n",
                    entry.getKey(),
                    totals.amount,
                    totals.tax,
                    totals.shipping
            );
        }
    }
}