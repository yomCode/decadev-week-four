package Tests;

import enums.Qualification;
import enums.Role;
import enums.Sex;
import exceptions.AccessDenialException;
import exceptions.InsufficientBalanceException;
import exceptions.OutOfStockException;
import exceptions.ProductIsNotAvaialbleEception;
import models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import services.CashierServiceImpl;
import services.CustomerServiceImpl;

import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class CashierServiceImplTest {




    @Test
    void raceConditionTest() {
        Store store1 = new Store();
        ProductFileReaderService reader = new ProductFileReaderService();
        store1.setProductsList(reader.productList());

        PrintReceipt receipt = new PrintReceipt();
        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);

        Customer customer1 = new Customer(1,"sugar", 500000.0, 10);
        Customer customer2 = new Customer(2, "sugar", 50000.0, 10);
        Customer customer3 = new Customer(3, "sugar", 20000.0, 10);
        Customer customer4 = new Customer(4, "sugar", 300000.0, 5);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store1, customerList);

        customerService.joinQueue(store1, customer1);
        customerService.joinQueue(store1, customer2);
        customerService.joinQueue(store1, customer3);
        customerService.joinQueue(store1, customer4);

        for(Products eachProduct : store1.getProductsList()){
            if(eachProduct.getProductName().equals(customer1.getProductName())) {
                receipt.setCashierName(staff3.getName());
                receipt.setDateTime(LocalDate.now());
                receipt.setReceiptNumber(0);
                receipt.setCustomerId(customer1.getCustomerId());
                receipt.setItemName(customer1.getProductName());
                receipt.setItemPrice(eachProduct.getRatePerUnit());
                receipt.setItemQty(customer1.getQty());
                receipt.setTotalCost(eachProduct.getRatePerUnit() * customer1.getQty());
            }
        }
        for(int i = 0; i < customerList.size(); i++){
            Thread thread = new Thread(new CashierServiceImpl(store1, staff3, customerList.get(i)));
            thread.start();
        }



        assertNotEquals(0, store1.getProductsList().get(4).getQuantity());
    }

    @Test
    void noRaceConditionTest() {
        Store store1 = new Store();
        ProductFileReaderService reader = new ProductFileReaderService();
        store1.setProductsList(reader.productList());

        PrintReceipt receipt = new PrintReceipt();
        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);

        Customer customer1 = new Customer(1,"sugar", 500000.0, 10);
        Customer customer2 = new Customer(2, "sugar", 50000.0, 10);
        Customer customer3 = new Customer(3, "sugar", 20000.0, 10);
        Customer customer4 = new Customer(4, "sugar", 300000.0, 5);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store1, customerList);

        customerService.joinQueue(store1, customer1);
        customerService.joinQueue(store1, customer2);
        customerService.joinQueue(store1, customer3);
        customerService.joinQueue(store1, customer4);

        for(Products eachProduct : store1.getProductsList()){
            if(eachProduct.getProductName().equals(customer1.getProductName())) {
                receipt.setCashierName(staff3.getName());
                receipt.setDateTime(LocalDate.now());
                receipt.setReceiptNumber(0);
                receipt.setCustomerId(customer1.getCustomerId());
                receipt.setItemName(customer1.getProductName());
                receipt.setItemPrice(eachProduct.getRatePerUnit());
                receipt.setItemQty(customer1.getQty());
                receipt.setTotalCost(eachProduct.getRatePerUnit() * customer1.getQty());
            }
        }
        for(int i = 0; i < customerList.size(); i++){
            Thread thread = new Thread(new CashierServiceImpl(store1, staff3, customerList.get(i)));
            thread.start();
            try {
                thread.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        assertEquals(0, store1.getProductsList().get(4).getQuantity());
    }


    @Test
    void sellProductSuccessful() {
        Store store1 = new Store();
        ProductFileReaderService reader = new ProductFileReaderService();
            store1.setProductsList(reader.productList());

        PrintReceipt receipt = new PrintReceipt();
        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);

        Customer customer1 = new Customer(1,"sugar", 500000.0, 20);
        Customer customer2 = new Customer(2, "sugar", 50000.0, 10);
        Customer customer3 = new Customer(3, "sugar", 20000.0, 10);
        Customer customer4 = new Customer(4, "sugar", 300000.0, 20);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store1, customerList);

        customerService.joinQueue(store1, customer1);
        customerService.joinQueue(store1, customer2);
        customerService.joinQueue(store1, customer3);
        customerService.joinQueue(store1, customer4);

        for(Products eachProduct : store1.getProductsList()){
            if(eachProduct.getProductName().equals(customer1.getProductName())) {
                receipt.setCashierName(staff3.getName());
                receipt.setDateTime(LocalDate.now());
                receipt.setReceiptNumber(0);
                receipt.setCustomerId(customer1.getCustomerId());
                receipt.setItemName(customer1.getProductName());
                receipt.setItemPrice(eachProduct.getRatePerUnit());
                receipt.setItemQty(customer1.getQty());
                receipt.setTotalCost(eachProduct.getRatePerUnit() * customer1.getQty());
            }
        }


        CashierServiceImpl cashierService = new CashierServiceImpl(store1, staff3, customer1);

        assertEquals(customer1.getQty() + " units of " + customer1.getProductName() + " sold to customer- " + customer1.getCustomerId() + "\n" + receipt, cashierService.sellProduct(store1, staff3, customer1));
    }


    @Test
    void insufficientFundException() {
        Store store1 = new Store();
        ProductFileReaderService reader = new ProductFileReaderService();
        store1.setProductsList(reader.productList());

        PrintReceipt receipt = new PrintReceipt();
        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);

        Customer customer1 = new Customer(1,"sugar", 500.0, 20);
        Customer customer2 = new Customer(2, "sugar", 50000.0, 10);
        Customer customer3 = new Customer(3, "sugar", 20000.0, 10);
        Customer customer4 = new Customer(4, "sugar", 300000.0, 20);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store1, customerList);

        customerService.joinQueue(store1, customer1);
        customerService.joinQueue(store1, customer2);
        customerService.joinQueue(store1, customer3);
        customerService.joinQueue(store1, customer4);


        for(Products eachProduct : store1.getProductsList()){
            if(eachProduct.getProductName().equals(customer1.getProductName())) {
                receipt.setCashierName(staff3.getName());
                receipt.setDateTime(LocalDate.now());
                receipt.setReceiptNumber(0);
                receipt.setCustomerId(customer1.getCustomerId());
                receipt.setItemName(customer1.getProductName());
                receipt.setItemPrice(eachProduct.getRatePerUnit());
                receipt.setItemQty(customer1.getQty());
                receipt.setTotalCost(eachProduct.getRatePerUnit() * customer1.getQty());
            }
        }

        Throwable throwable =  assertThrows(InsufficientBalanceException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                CashierServiceImpl cashierService = new CashierServiceImpl(store1, staff3, customer1);
                cashierService.sellProduct(store1, staff3, customer1);
            }
        });

        assertEquals( "You do not have sufficient fund to complete this transaction", throwable.getMessage());
    }


    @Test
    void outOfStockException() {
        Store store1 = new Store();
        ProductFileReaderService reader = new ProductFileReaderService();
        store1.setProductsList(reader.productList());

        PrintReceipt receipt = new PrintReceipt();
        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);

        Customer customer1 = new Customer(1,"sugar", 500.0, 60);
        Customer customer2 = new Customer(2, "sugar", 50000.0, 10);
        Customer customer3 = new Customer(3, "sugar", 20000.0, 10);
        Customer customer4 = new Customer(4, "sugar", 300000.0, 20);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store1, customerList);

        customerService.joinQueue(store1, customer1);
        customerService.joinQueue(store1, customer2);
        customerService.joinQueue(store1, customer3);
        customerService.joinQueue(store1, customer4);


        for(Products eachProduct : store1.getProductsList()){
            if(eachProduct.getProductName().equals(customer1.getProductName())) {
                receipt.setCashierName(staff3.getName());
                receipt.setDateTime(LocalDate.now());
                receipt.setReceiptNumber(0);
                receipt.setCustomerId(customer1.getCustomerId());
                receipt.setItemName(customer1.getProductName());
                receipt.setItemPrice(eachProduct.getRatePerUnit());
                receipt.setItemQty(customer1.getQty());
                receipt.setTotalCost(eachProduct.getRatePerUnit() * customer1.getQty());
            }
        }

        Throwable throwable =  assertThrows(OutOfStockException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                CashierServiceImpl cashierService = new CashierServiceImpl(store1, staff3, customer1);
                cashierService.sellProduct(store1, staff3, customer1);
            }
        });

        assertEquals( "Product out of Stock", throwable.getMessage());
    }

    @Test
    void productNotAvailableException() {
        Store store1 = new Store();
        ProductFileReaderService reader = new ProductFileReaderService();
        store1.setProductsList(reader.productList());

        PrintReceipt receipt = new PrintReceipt();
        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);

        Customer customer1 = new Customer(1,"Beans", 500.0, 60);
        Customer customer2 = new Customer(2, "sugar", 50000.0, 10);
        Customer customer3 = new Customer(3, "sugar", 20000.0, 10);
        Customer customer4 = new Customer(4, "sugar", 300000.0, 20);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store1, customerList);

        customerService.joinQueue(store1, customer1);
        customerService.joinQueue(store1, customer2);
        customerService.joinQueue(store1, customer3);
        customerService.joinQueue(store1, customer4);


        for(Products eachProduct : store1.getProductsList()){
            if(eachProduct.getProductName().equals(customer1.getProductName())) {
                receipt.setCashierName(staff3.getName());
                receipt.setDateTime(LocalDate.now());
                receipt.setReceiptNumber(0);
                receipt.setCustomerId(customer1.getCustomerId());
                receipt.setItemName(customer1.getProductName());
                receipt.setItemPrice(eachProduct.getRatePerUnit());
                receipt.setItemQty(customer1.getQty());
                receipt.setTotalCost(eachProduct.getRatePerUnit() * customer1.getQty());
            }
        }

        Throwable throwable =  assertThrows(ProductIsNotAvaialbleEception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                CashierServiceImpl cashierService = new CashierServiceImpl(store1, staff3, customer1);
                cashierService.sellProduct(store1, staff3, customer1);
            }
        });

        assertEquals( "Product is currently unavailable, kindly check back later", throwable.getMessage());
    }

    @Test
    void accessDeniedException() {
        Store store1 = new Store();
        ProductFileReaderService reader = new ProductFileReaderService();
        store1.setProductsList(reader.productList());

        PrintReceipt receipt = new PrintReceipt();
        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.MANAGER);

        Customer customer1 = new Customer(1,"Beans", 500.0, 60);
        Customer customer2 = new Customer(2, "sugar", 50000.0, 10);
        Customer customer3 = new Customer(3, "sugar", 20000.0, 10);
        Customer customer4 = new Customer(4, "sugar", 300000.0, 20);

        LinkedList<Customer> customerList = new LinkedList<>();

        CustomerServiceImpl customerService = new CustomerServiceImpl(store1, customerList);

        customerService.joinQueue(store1, customer1);
        customerService.joinQueue(store1, customer2);
        customerService.joinQueue(store1, customer3);
        customerService.joinQueue(store1, customer4);


        for(Products eachProduct : store1.getProductsList()){
            if(eachProduct.getProductName().equals(customer1.getProductName())) {
                receipt.setCashierName(staff3.getName());
                receipt.setDateTime(LocalDate.now());
                receipt.setReceiptNumber(0);
                receipt.setCustomerId(customer1.getCustomerId());
                receipt.setItemName(customer1.getProductName());
                receipt.setItemPrice(eachProduct.getRatePerUnit());
                receipt.setItemQty(customer1.getQty());
                receipt.setTotalCost(eachProduct.getRatePerUnit() * customer1.getQty());
            }
        }

        Throwable throwable =  assertThrows(AccessDenialException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                CashierServiceImpl cashierService = new CashierServiceImpl(store1, staff3, customer1);
                cashierService.sellProduct(store1, staff3, customer1);
            }
        });

        assertEquals( "Access Denied!", throwable.getMessage());
    }



}