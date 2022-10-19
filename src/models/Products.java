package models;

import enums.Category;

public class Products{
    //FIELDS---------------------------------------------------------------------------------------->
    private Long productId;
    private String productName;
    private Category category;
    private Double ratePerUnit;
    private Integer quantity;
    private  StringBuilder status;



    //CONSTRUCTOR-------------------------------------------------------------------------------------->
    public Products(){

    }

    public Products(Long productId, String productName, Category category, Double ratePerUnit, Integer quantity, StringBuilder status) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.ratePerUnit = ratePerUnit;
        this.quantity = quantity;
        this.status = status;
    }

    //GETTERS & SETTERS------------------------------------------------------------------>
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getRatePerUnit() {
        return ratePerUnit;
    }

    public void setRatePerUnit(Double ratePerUnit) {
        this.ratePerUnit = ratePerUnit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public StringBuilder getStatus() {
        if(getQuantity() > 0){
            return status = new StringBuilder("AVAILABLE");
        }else{
            return status = new StringBuilder("OUT OF STOCK");
        }

    }

    public void setStatus(StringBuilder status) {
        this.status = status;

    }


    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", ratePerUnit=" + ratePerUnit +
                ", quantity=" + quantity +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
