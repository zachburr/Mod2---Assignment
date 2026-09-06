package impl;

import iface.SalesInput;
import model.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides sales data directly from values stored in the program.
 */
public class SalesInputConsole implements SalesInput {

    @Override
    public List<Sale> getSales() {

        // Creates an empty list that will hold all Sale objects.
        List<Sale> sales = new ArrayList<>();

        // Creates each sale and adds it to the list.
        sales.add(new Sale("Stacy Read", "United States", 190.95));
        sales.add(new Sale("R.B. Whitaker", "United States", 54.33));
        sales.add(new Sale("Rabindranath Tagore", "India", 117.89));
        sales.add(new Sale("Lindsay Ellis", "United States", 25.19));
        sales.add(new Sale("Shin Takahashi", "Japan", 145.00));
        sales.add(new Sale("Erich Gamma", "United States", 53.63));
        sales.add(new Sale("Iain M. Banks", "Scotland", 75.42));
        sales.add(new Sale("Meg Ray", "United States", 11.99));

        // Returns the finished list to CustomReport.
        return sales;
    }
}