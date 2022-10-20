package models;

import java.time.LocalDate;


public class PrintReceipt extends Customer{

    //FIELDS-------------------------------------------------------------------------->
    private  LocalDate dateTime;
    private Integer receiptNumber;
    private String itemName;
    private Integer itemQty;
    private Double itemPrice;
    private Double totalCost;
    private String cashierName;
    private Integer customerId;

    public PrintReceipt(){

    }

    public PrintReceipt(LocalDate dateTime, Integer receiptNumber, String itemName, Integer itemQty,
                        Double itemPrice, Double totalCost, String cashierName, Integer customerId) {
        this.dateTime = dateTime;
        this.receiptNumber = receiptNumber;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
        this.totalCost = totalCost;
        this.cashierName = cashierName;
        this.customerId = customerId;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(Integer receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemQty() {
        return itemQty;
    }

    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    @Override
    public Integer getCustomerId() {
        return customerId;
    }

    @Override
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getTotalCost() {
        return totalCost;
    }


    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "RECEIPT \n" + "====================================\n" +
                "DateTime: " + dateTime + "\n" +
                "ReceiptNumber: " + receiptNumber + "\n" +
                "CustomerId: " + customerId + "\n" +
                "ItemName: " + itemName  +
                " ItemQty: " + itemQty +
                " ItemPrice: " + itemPrice + "\n" + "Total Cost: "
                + totalCost + "\n\n" + "CashierName: " + cashierName;
    }


}
