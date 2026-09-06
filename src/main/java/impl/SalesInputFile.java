package impl;

import iface.SalesInput;
import model.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an input source that will read sales from a file.
 */
public class SalesInputFile implements SalesInput {

    @Override
    public List<Sale> getSales() {

        List<Sale> sales = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("sales.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length < 4) {
                    continue;
                }

                String customer = parts[0].trim();
                String country = parts[1].trim();
                double amount = Double.parseDouble(parts[2].trim());
                double tax = Double.parseDouble(parts[3].trim());

                Sale sale = new Sale(customer, country, amount);
                sale.setTax(tax);
                sales.add(sale);
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Error reading sales.txt");
        }

        return sales;
    }
}
