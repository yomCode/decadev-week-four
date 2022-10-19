package services;

import Interfaces.CashierInterface;
import enums.Role;
import exceptions.AccessDenialException;
import models.*;

import java.util.PriorityQueue;
import java.util.Queue;

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
            if(customerService.buyProduct(store, customer).equals("Product purchased successfully by customer-" + customer.getCustomerId())){
                for(int i =0; i< store.getProductsList().size(); i++){
                    if(store.getProductsList().get(i).getProductName().equals(customer.getProductName().toLowerCase())){
                        sellStatus.append(customer.getQty()).append(" units of ").append(customer.getProductName()).append(" sold to Customer-").append(customer.getCustomerId()) ;
                        //).append(receipt.printReceipt(store, staff, customer));

                        store.getProductsList().get(i).setQuantity(store.getProductsList().get(i).getQuantity() - customer.getQty());
                    }

                    if (store.getProductsList().get(i).getQuantity() == 0) {
                        store.getProductsList().get(i).setStatus(new StringBuilder("OUT OF STOCK!"));
                    } else {
                        store.getProductsList().get(i).setStatus(new StringBuilder("AVAILABLE"));
                    }

                }

            }else{
                sellStatus.append("Product not sold");
            }

        }else{
            sellStatus.append("Access Denied!");
        }
        return sellStatus.toString();
    }

    @Override
    public void run() {
            System.out.println(sellProduct(store, staff, customer));
    }
}

