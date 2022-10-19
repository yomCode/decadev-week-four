package models;

import Interfaces.PrintReceiptInterface;
import enums.Role;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PrintReceipt extends Customer{

//    //FIELDS-------------------------------------------------------------------------->
//    private  LocalDateTime dateTime;
//    private Integer slipNumber;
//
//    public PrintReceipt(){
//
//
//    }
//
//    public LocalDateTime getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(LocalDateTime dateTime) {
//        this.dateTime = dateTime;
//    }
//
//    public Integer getSlipNumber() {
//        return slipNumber;
//    }
//
//    public void setSlipNumber(Integer slipNumber) {
//        this.slipNumber = slipNumber;
//    }
//
//    @Override
//    public String toString() {
//        return "PrintReceipt{" +
//                "dateTime=" + dateTime +
//                ", slipNumber=" + slipNumber +
//                '}';
//    }
//
//    @Override
//    public  String printReceipt(Store store, Staff staff, Customer customer){
//        LocalDate dateTime = LocalDate.now();
//        slipNumber = 0; //(int) (Math.random() * 1_000_000);
//
//        if(staff.getRole().equals(Role.CASHIER)){
//
//            ProductFileReaderService reader = new ProductFileReaderService();
//            reader.productList();
//                    String items = "";
//
//                        for(int i = 0; i< store.getCustomerQueue().element().getPurchaseCart().size(); i++) {
//                            String itemName = store.getCustomerQueue().element().getPurchaseCart().get(i).getItemName();
//                            Integer itemQty = store.getCustomerQueue().element().getPurchaseCart().get(i).getItemQty();
//                            Double itemPrice = store.getCustomerQueue().element().getPurchaseCart().get(i).getPrice();
//                            items += "Item: " + itemName + "   itemQty: " + itemQty + "    Price: " + itemPrice + "\n";
//                        }
//
//
//                    return "RECEIPT \n" + "--------------------- \n" + "Date: " + dateTime + "\nSlip Number: " + slipNumber + "\n\n"
//                                    + items + "\n    Total: " + store.getCustomerQueue().element().getTotalCost() +
//                                    "\nCashier: " + staff.getName() + "\n \nGOODS BOUGHT IN GOOD CONDITION ARE NOT RETURNABLE \n"
//                                    + "Thanks for your patronage!\n\n";
//
//
//        }
//            return "Access Denied!";
//
//    }

}
