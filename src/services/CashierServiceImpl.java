package services;

import Interfaces.CashierInterface;
import enums.Role;
import exceptions.*;
import models.*;

import java.time.LocalDate;


public class CashierServiceImpl implements Runnable, CashierInterface {
    Store store;
    Staff staff;
    Customer customer;
    CustomerServiceImpl customerService;

    public CashierServiceImpl(Store store, Staff staff, Customer customer, CustomerServiceImpl customerService) {
        this.store = store;
        this.staff = staff;
        this.customer = customer;
        this.customerService = customerService;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String sellProduct(Store store, Staff staff, Customer customer){
        //unique Field----------------------------------------------------
        PrintReceipt receipt = new PrintReceipt();

        StringBuilder sellStatus = new StringBuilder();

        if(staff.getRole().equals(Role.CASHIER)){
                for(Products eachProduct : store.getProductsList()){
                    if(eachProduct.getProductName().equals(customer.getProductName().toLowerCase())) {
                        if (eachProduct.getQuantity() == 0) {
                            eachProduct.setStatus(new StringBuilder("OUT OF STOCK!"));
                        } else {
                            eachProduct.setStatus(new StringBuilder("AVAILABLE"));
                        }
                        if (customer.getQty() > 0 && eachProduct.getQuantity() >= customer.getQty()) {
                            if (eachProduct.getQuantity() <= 0) return "OUT OF STOCK!";
                            if ((eachProduct.getRatePerUnit() * customer.getQty()) <= customer.getAvailableCash()) {
                                receipt.setCashierName(staff.getName());
                                receipt.setDateTime(LocalDate.now());
                                receipt.setReceiptNumber(0);
                                receipt.setCustomerId(customer.getCustomerId());
                                receipt.setItemName(customer.getProductName());
                                receipt.setItemPrice(eachProduct.getRatePerUnit());
                                receipt.setItemQty(customer.getQty());
                                receipt.setTotalCost(eachProduct.getRatePerUnit() * customer.getQty());


//                                sellStatus.append(customer.getQty()).append(" units of ").append(customer.getProductName()).append(" sold to Customer-").append(customer.getCustomerId()).append("\n").append(receipt);
                                eachProduct.setQuantity(eachProduct.getQuantity() - customer.getQty());
                                customer.setAvailableCash(customer.getAvailableCash() - (eachProduct.getRatePerUnit() * customer.getQty()));
                                return customer.getQty() + " units of " + customer.getProductName() + " sold to customer- " + customer.getCustomerId() + "\n" + receipt;

                            } else {
                                throw new InsufficientBalanceException("You do not have sufficient fund to complete this transaction");
                            }

                        }else {
                            throw new OutOfStockException("Product out of Stock");
                        }

                    }
                }
            throw new ProductIsNotAvaialbleEception("Product is currently unavailable, kindly check back later");
        }else{
            throw new AccessDenialException("Access Denied!");
        }
//        return sellStatus.toString();
    }

    @Override
    public void run() {
            System.out.println(sellProduct(store, staff, customer));
    }
}

