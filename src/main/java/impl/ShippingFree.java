package impl;

import iface.ShippingPolicy;
import model.Sale;

/**
 * Shipping policy where every order receives free shipping.
 */
public class ShippingFree implements ShippingPolicy {

    @Override
    public void applyShipping(Sale sale) {

        // Sets the shipping cost for the sale to zero.
        sale.setShipping(0.0);
    }
}