package services;

import Interfaces.CustomerInterface;
import models.*;

import java.util.LinkedList;


public class CustomerServiceImpl implements CustomerInterface {
    Customer customer;
    Store store;
    LinkedList<Customer> custList;

    public CustomerServiceImpl(Store store, LinkedList<Customer> custList) {
        this.store = store;
        this.custList = custList;
    }

    public void setCustList(LinkedList<Customer> custList) {
        this.custList = custList;
    }

    @Override
    public void joinQueue(Store store, Customer customer){
        store.setCustomerQueue(custList);

        for(int i = 0; i< store.getProductsList().size(); i++){
            if(store.getProductsList().get(i).getProductName().equals(customer.getProductName())){
                store.getCustomerQueue().add(customer);
            }
        }

    }
}
