package services;

import Interfaces.CustomerInterface;
import models.*;


public class CustomerServiceImpl implements CustomerInterface {
    Customer customer;
    Store store;

    public CustomerServiceImpl(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
    }

    public Customer getCustomer() {
        return customer;
    }

}
