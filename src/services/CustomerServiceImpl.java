package services;

import Interfaces.CustomerInterface;
import exceptions.InsufficientBalanceException;
import exceptions.ProductIsNotAvaialbleEception;
import models.*;

import java.util.List;
import java.util.Queue;

public class CustomerServiceImpl extends Thread implements CustomerInterface {
    Customer customer;
    Store store;

    public CustomerServiceImpl(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String buyProduct(Store store, Customer customer){
        List<Products> availableProducts = store.getProductsList();

        for(int i = 0; i< availableProducts.size(); i++){
            //Check if product is available on the available product list--------------------------------------------------
            if(availableProducts.get(i).getProductName().equalsIgnoreCase(customer.getProductName())){
                //Check if selected product is in stock-----------------------------------------------------------------------
                if(availableProducts.get(i).getQuantity() <= 0) return "OUT OF STOCK!";
                //Check if there is enough quantity to serve the customer's need----------------------------------------------
                if(availableProducts.get(i).getQuantity() > 0 && availableProducts.get(i).getQuantity() >= customer.getQty()){
                    //Check if customer have enough cash to pay for the product------------------------------------------------
                    if((availableProducts.get(i).getRatePerUnit()* customer.getQty()) <= customer.getAvailableCash()){

                        return "Product purchased successfully by customer-" + customer.getCustomerId();

                    }else{
                        throw new InsufficientBalanceException("Insufficient balance to complete purchase");
                    }


                }else{
                    return "Not enough quantity available in the store";
                }
            }

        }
        throw new ProductIsNotAvaialbleEception("Product is not available");
    }

    @Override
    public void run() {
        System.out.println(buyProduct(store, customer));
    }
}
