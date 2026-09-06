package impl;

import iface.ShippingPolicy;
import model.Sale;

/**
 * Shipping policy that assigns a shipping rate based on country.
 */
public class ShippingDomestic implements ShippingPolicy {

    @Override
    public void applyShipping(Sale sale) {

        // Checks the sale's country and assigns its shipping cost.
        switch (sale.getCountry()) {

            case "United States":
                sale.setShipping(29.95);
                break;

            case "Japan":
                sale.setShipping(14.50);
                break;

            case "Scotland":
                sale.setShipping(7.54);
                break;

            case "India":
                sale.setShipping(11.79);
                break;

            // If the country is not listed above, shipping defaults to zero.
            default:
                sale.setShipping(0.0);
                break;
        }
    }
}