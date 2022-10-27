package services;

import Interfaces.CashierInterface;
import enums.Role;
import exceptions.*;
import models.*;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;


public class CashierServiceImpl implements Runnable, CashierInterface {
    Store store;
    Staff staff;
    Customer customer;

    public CashierServiceImpl(Store store, Staff staff, Customer customer) {
        this.store = store;
        this.staff = staff;
        this.customer = customer;
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


    private final BiPredicate<Store, Customer> enoughQtyAvailable = (store, customer) ->
            isAvailable(store, customer).getQuantity() >= customer.getQty();


   private final BiPredicate<Store, Customer> fundIsEnough = (store, customer) ->
            (isAvailable(store, customer).getRatePerUnit() * customer.getQty()) <= customer.getAvailableCash();


    private final BiFunction<Store, Customer, PrintReceipt> issueReceipt = (store, customer) -> {
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
    };

    private void updateBalance(Store store, Customer customer) {
        customer.setAvailableCash(customer.getAvailableCash() - (isAvailable(store, customer).getRatePerUnit() * customer.getQty()));
    }

    private void updateQty(Store store, Customer customer) {
        isAvailable(store, customer).setQuantity(isAvailable(store, customer).getQuantity() - customer.getQty());
    }

    private final Function<Store, String> productAvailabilityStatus = Store ->
            isAvailable(store, customer).getQuantity() == 0 ? "AVAILABLE" : "OUT OF STOCK";


    @Override
    public String sellProduct(Store store, Staff staff, Customer customer) {

        String sellStatus = "";

        if(haveAccess(staff).equals(true)){
            isAvailable(store,customer);
            productAvailabilityStatus.apply(store);
            if(enoughQtyAvailable.test(store,customer)){

                if(fundIsEnough.test(store,customer)){
                    updateQty(store,customer);
                    updateBalance(store,customer);

                    sellStatus += customer.getQty() + " units of " + customer.getProductName()
                            + " sold to customer- " + customer.getCustomerId() + "\n" + issueReceipt.apply(store,customer);

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

    }


    @Override
    public void run() {
            System.out.println(sellProduct(store, staff, customer));
    }
}

