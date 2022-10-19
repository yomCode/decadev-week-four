package models;

import services.CustomerServiceImpl;

public class Customer {


    //FIELDS------------------------------------------------------------------>
    private Integer customerId;
    private String productName;
    private Integer qty;
    private Double availableCash;


    //CONSTRUCTORS------------------------------------------------------------------>

    public Customer(){

    }

    public Customer(Integer customerId, String productName, Double availableCash, Integer qty) {
        this.customerId = customerId;
        this.productName = productName;
        this.availableCash = availableCash;
        this.qty = qty;
    }

    //GETTERS & SETTERS------------------------------------------------------------------>


    public Double getAvailableCash() {
        return availableCash;
    }

    public void setAvailableCash(Double availableCash) {
        this.availableCash = availableCash;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "productName='" + productName + '\'' +
                ", qty=" + qty + ", cashPaid="
                + availableCash +
                '}';
    }
}
