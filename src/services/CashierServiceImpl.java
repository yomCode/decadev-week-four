package services;

import Interfaces.CashierInterface;
import enums.Role;
import exceptions.*;
import models.*;

import java.time.LocalDate;
import java.util.List;



public class CashierServiceImpl implements Runnable, CashierInterface {
    Store store;
    Staff staff;
    Customer customer;

    public CashierServiceImpl(Store store, Staff staff, Customer customer) {
        this.store = store;
        this.staff = staff;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    private Boolean haveAccess(Staff staff){
        return staff.getRole().equals(Role.CASHIER);
    }

    private Products isAvailable(Store store, Customer customer) {
        Products theProduct;
        List<Products> list = store.getProductsList().stream()
                .filter(products -> products.getProductName().equalsIgnoreCase(customer.getProductName()))
                .toList();
        theProduct = list.get(0);

        return theProduct;
    }

    private Boolean enoughQtyAvailable(Store store, Customer customer) {
        return isAvailable(store, customer).getQuantity() >= customer.getQty();
    }

    private Boolean fundIsEnough(Store store, Customer customer) {
        return (isAvailable(store, customer).getRatePerUnit() * customer.getQty()) <= customer.getAvailableCash();
    }

    private PrintReceipt issueReceipt(Store store, Customer customer) {
        PrintReceipt receipt = new PrintReceipt();

        receipt.setCashierName(staff.getName());
        receipt.setDateTime(LocalDate.now());
        receipt.setReceiptNumber(0);
        receipt.setCustomerId(customer.getCustomerId());
        receipt.setItemName(customer.getProductName());
        receipt.setItemPrice(isAvailable(store, customer).getRatePerUnit());
        receipt.setItemQty(customer.getQty());
        receipt.setTotalCost(isAvailable(store, customer).getRatePerUnit() * customer.getQty());

        return receipt;
    }

    private void updateBalance(Store store, Customer customer) {
        customer.setAvailableCash(customer.getAvailableCash() - (isAvailable(store, customer).getRatePerUnit() * customer.getQty()));
    }

    private void updateQty(Store store, Customer customer) {
        isAvailable(store, customer).setQuantity(isAvailable(store, customer).getQuantity() - customer.getQty());
    }

    private String productAvailabilityStatus(Store store,Customer customer){
       return  isAvailable(store, customer).getQuantity() == 0 ? "AVAILABLE" : "OUT OF STOCK";
    }

    @Override
    public String sellProduct(Store store, Staff staff, Customer customer) {

        String sellStatus = "";

        if(haveAccess(staff).equals(true)){
            isAvailable(store,customer);
            productAvailabilityStatus(store,customer);
            if(enoughQtyAvailable(store,customer)){

                if(fundIsEnough(store,customer)){
                    updateQty(store,customer);
                    updateBalance(store,customer);

                    sellStatus += customer.getQty() + " units of " + customer.getProductName()
                            + " sold to customer- " + customer.getCustomerId() + "\n" + issueReceipt(store,customer);

                }else{
                    throw new InsufficientBalanceException("You do not have sufficient fund to complete this transaction");
                }
            }else{
                throw new OutOfStockException("Product out of Stock");
            }
        }else{
            throw new AccessDenialException("Access Denied!");
        }

        return sellStatus;


//        for(Products product: store.getProductsList()){
//
//            Function<Customer, String> isAvailable = customer1 ->
//                    customer1.getProductName().equalsIgnoreCase(product.getProductName()) ? "Available" : null;
//
//
//            Function<Customer, Products> isQtyEnough = customer1 ->
//                    product.getQuantity() >= customer1.getQty() ? product : null;
//
//            Function<Customer, Products> isFundSufficient = customer1 ->
//                    (product.getRatePerUnit() * customer1.getQty()) <= customer1.getAvailableCash() ? product : null;
//
//            Function<Products, PrintReceipt> salesIsSuccessful = isAvailable.andThen().andThen()
//
//
//        }


//        if(staff.getRole().equals(Role.CASHIER)){
//                for(Products eachProduct : store.getProductsList()){
//                    if(eachProduct.getProductName().equals(customer.getProductName().toLowerCase())) {
//                        if (eachProduct.getQuantity() == 0) {
//                            eachProduct.setStatus(new StringBuilder("OUT OF STOCK!"));
//                        } else {
//                            eachProduct.setStatus(new StringBuilder("AVAILABLE"));
//                        }
//                        if (customer.getQty() > 0 && eachProduct.getQuantity() >= customer.getQty()) {
//                            if (eachProduct.getQuantity() <= 0) return "OUT OF STOCK!";
//                            if ((eachProduct.getRatePerUnit() * customer.getQty()) <= customer.getAvailableCash()) {
//                                receipt.setCashierName(staff.getName());
//                                receipt.setDateTime(LocalDate.now());
//                                receipt.setReceiptNumber(0);
//                                receipt.setCustomerId(customer.getCustomerId());
//                                receipt.setItemName(customer.getProductName());
//                                receipt.setItemPrice(eachProduct.getRatePerUnit());
//                                receipt.setItemQty(customer.getQty());
//                                receipt.setTotalCost(eachProduct.getRatePerUnit() * customer.getQty());
//
//
//                                eachProduct.setQuantity(eachProduct.getQuantity() - customer.getQty());
//                                customer.setAvailableCash(customer.getAvailableCash() - (eachProduct.getRatePerUnit() * customer.getQty()));
//                                return customer.getQty() + " units of " + customer.getProductName() + " sold to customer- " + customer.getCustomerId() + "\n" + receipt;
//
//                            } else {
//                                throw new InsufficientBalanceException("You do not have sufficient fund to complete this transaction");
//                            }
//
//                        }else {
//                            throw new OutOfStockException("Product out of Stock");
//                        }
//
//                    }
//                }
//            throw new ProductIsNotAvaialbleEception("Product is currently unavailable, kindly check back later");
//        }else{
//            throw new AccessDenialException("Access Denied!");
//        }

    }


    @Override
    public void run() {
            System.out.println(sellProduct(store, staff, customer));
    }
}

