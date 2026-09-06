package iface;

import model.Sale;

/**
 * Defines how shipping policies must calculate shipping for a sale.
 */
public interface ShippingPolicy {

    /**
     * Applies a shipping cost to the given sale.
     */
    void applyShipping(Sale sale);
}