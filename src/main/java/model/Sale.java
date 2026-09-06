package model;

/**
 * Represents one customer's sale.
 */
public class Sale {

    private String customer;
    private String country;
    private double amount;
    private double tax;
    private double shipping;

    /**
     * Empty constructor.
     * Allows a Sale object to be created before its values are assigned.
     */
    public Sale() {
    }

    /**
     * Creates a sale with its basic information.
     * Tax and shipping are calculated later.
     */
    public Sale(String customer, String country, double amount) {
        this.customer = customer;
        this.country = country;
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    /**
     * Calculates the final cost of the sale.
     */
    public double getTotal() {
        return amount + tax + shipping;
    }
}