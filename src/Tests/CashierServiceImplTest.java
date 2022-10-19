//package Tests;
//
//import enums.Qualification;
//import enums.Role;
//import enums.Sex;
//import models.*;
//import org.junit.jupiter.api.Test;
//import services.CashierServiceImpl;
//import services.CustomerServiceImpl;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CashierServiceImplTest {
//
//
//
//
//    @Test
//    void sellProductSuccessfulBasedOnQuantity() {
//        Store store1 = new Store();
//        ProductFileReaderService reader = new ProductFileReaderService();
//            store1.setProductsList(reader.productList());
//
//        PrintReceipt receipt = new PrintReceipt();
//        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);
//
//        CashierServiceImpl cashier = new CashierServiceImpl();
//
//        ArrayList<Item> cartProduct = new ArrayList<>();
//        ArrayList<Item> cartProduct1 = new ArrayList<>();
//        ArrayList<Item> cartProduct2 = new ArrayList<>();
//        ArrayList<Item> cartProduct3 = new ArrayList<>();
//
//
//        Customer customer1 = new Customer(1,cartProduct, 100000.0);
//        Customer customer2 = new Customer(2, cartProduct1, 50000.0);
//        Customer customer3 = new Customer(3, cartProduct2, 20000.0);
//        Customer customer4 = new Customer(4, cartProduct3, 300000.0);
//
//
//        CustomerServiceImpl customerService = new CustomerServiceImpl();
//
//        //Add items to customer1 Cart-------------------------------------------------------------------------
//        Item item1 = new Item("milo", 30);
//        Item item2 = new Item("monster", 5);
//        Item item3 = new Item("orijin", 2);
//        Item item4 = new Item("tissue paper", 20);
//
//        customerService.addToCart(store1, item1, customer1);
//        customerService.addToCart(store1, item2, customer1);
//        customerService.addToCart(store1, item3, customer1);
//        customerService.addToCart(store1, item4, customer1);
//
//        //Add items to customer2 Cart-------------------------------------------------------------------------
//        Item item5 = new Item("milk", 30);
//        Item item6 = new Item("spoon", 15);
//        Item item7 = new Item("knife", 2);
//        Item item8 = new Item("sugar", 25);
//
//        customerService.addToCart(store1, item5, customer2);
//        customerService.addToCart(store1, item6, customer2);
//        customerService.addToCart(store1, item7, customer2);
//        customerService.addToCart(store1, item8, customer2);
//
//        //Add items to customer3 Cart-------------------------------------------------------------------------
//        Item item9 = new Item("sanitary pad", 5);
//        Item item10 = new Item("orijin", 10);
//        Item item11 = new Item("milk", 5);
//        Item item12 = new Item("peeler", 2);
//
//        customerService.addToCart(store1, item9, customer3);
//        customerService.addToCart(store1, item10, customer3);
//        customerService.addToCart(store1, item11, customer3);
//        customerService.addToCart(store1, item12, customer3);
//
//        Item item13 = new Item("5alive", 120);
//        Item item14 = new Item("monster", 10);
//        Item item15 = new Item("milk", 5);
//        Item item16 = new Item("peeler", 1);
//
//        customerService.addToCart(store1, item13, customer4);
//        customerService.addToCart(store1, item14, customer4);
//        customerService.addToCart(store1, item15, customer4);
//        customerService.addToCart(store1, item16, customer4);
//
//
//
//        //Setting the Array values to customers Cart-----------------------------------------------------------------------------------
//        customer1.setPurchaseCart(cartProduct);
//        customer2.setPurchaseCart(cartProduct1);
//        customer3.setPurchaseCart(cartProduct2);
//        customer4.setPurchaseCart(cartProduct3);
//
//        //Adding the customers to Priority Queue which is a field in the Store entity (Position in the queue is determined by the number of total quantity)---
//        PriorityQueue<Customer> customerQueue = new PriorityQueue<>(customer1);
//
//
//        customerQueue.add(customer1);
//        customerQueue.add(customer2);
//        customerQueue.add(customer3);
//        customerQueue.add(customer4);
//
//        store1.setCustomerQueue(customerQueue);
//
//
//        String expected = "Product sold to customer: 2" +  "\n\n" + receipt.printReceipt(store1, staff3, store1.getCustomer());
//
//        assertEquals(expected, cashier.sellProduct(store1, staff3, customerQueue));
//    }
//
//    @Test
//    void sellProductUnsuccessfulBasedOnQuantity() {
//        Store store1 = new Store();
//        ProductFileReaderService reader = new ProductFileReaderService();
//        store1.setProductsList(reader.productList());
//
//        PrintReceipt receipt = new PrintReceipt();
//        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);
//
//        CashierServiceImpl cashier = new CashierServiceImpl();
//
//        ArrayList<Item> cartProduct = new ArrayList<>();
//        ArrayList<Item> cartProduct1 = new ArrayList<>();
//        ArrayList<Item> cartProduct2 = new ArrayList<>();
//        ArrayList<Item> cartProduct3 = new ArrayList<>();
//
//
//        Customer customer1 = new Customer(1,cartProduct, 100000.0);
//        Customer customer2 = new Customer(2, cartProduct1, 500.0);
//        Customer customer3 = new Customer(3, cartProduct2, 20000.0);
//        Customer customer4 = new Customer(4, cartProduct3, 300000.0);
//
//
//        CustomerServiceImpl customerService = new CustomerServiceImpl();
//
//        //Add items to customer1 Cart-------------------------------------------------------------------------
//        Item item1 = new Item("milo", 30);
//        Item item2 = new Item("monster", 5);
//        Item item3 = new Item("orijin", 2);
//        Item item4 = new Item("tissue paper", 20);
//
//        customerService.addToCart(store1, item1, customer1);
//        customerService.addToCart(store1, item2, customer1);
//        customerService.addToCart(store1, item3, customer1);
//        customerService.addToCart(store1, item4, customer1);
//
//        //Add items to customer2 Cart-------------------------------------------------------------------------
//        Item item5 = new Item("milk", 30);
//        Item item6 = new Item("spoon", 15);
//        Item item7 = new Item("knife", 2);
//        Item item8 = new Item("sugar", 25);
//
//        customerService.addToCart(store1, item5, customer2);
//        customerService.addToCart(store1, item6, customer2);
//        customerService.addToCart(store1, item7, customer2);
//        customerService.addToCart(store1, item8, customer2);
//
//        //Add items to customer3 Cart-------------------------------------------------------------------------
//        Item item9 = new Item("sanitary pad", 5);
//        Item item10 = new Item("orijin", 10);
//        Item item11 = new Item("milk", 5);
//        Item item12 = new Item("peeler", 2);
//
//        customerService.addToCart(store1, item9, customer3);
//        customerService.addToCart(store1, item10, customer3);
//        customerService.addToCart(store1, item11, customer3);
//        customerService.addToCart(store1, item12, customer3);
//
//        Item item13 = new Item("5alive", 120);
//        Item item14 = new Item("monster", 10);
//        Item item15 = new Item("milk", 5);
//        Item item16 = new Item("peeler", 1);
//
//        customerService.addToCart(store1, item13, customer4);
//        customerService.addToCart(store1, item14, customer4);
//        customerService.addToCart(store1, item15, customer4);
//        customerService.addToCart(store1, item16, customer4);
//
//
//
//        //Setting the Array values to customers Cart-----------------------------------------------------------------------------------
//        customer1.setPurchaseCart(cartProduct);
//        customer2.setPurchaseCart(cartProduct1);
//        customer3.setPurchaseCart(cartProduct2);
//        customer4.setPurchaseCart(cartProduct3);
//
//        //Adding the customers to Priority Queue which is a field in the Store entity (Position in the queue is determined by the number of total quantity)---
//        PriorityQueue<Customer> customerQueue = new PriorityQueue<>(customer1);
//
//
//        customerQueue.add(customer1);
//        customerQueue.add(customer2);
//        customerQueue.add(customer3);
//        customerQueue.add(customer4);
//
//        store1.setCustomerQueue(customerQueue);
//
//
//        String expected = "Insufficient balance to sell to Customer: 2";
//
//        assertEquals(expected, cashier.sellProduct(store1, staff3, customerQueue));
//    }
//
//
//
//    @Test
//    void sellProductSuccessfulBasedOnFIFO() {
//        Store store1 = new Store();
//        ProductFileReaderService reader = new ProductFileReaderService();
//        store1.setProductsList(reader.productList());
//
//        PrintReceipt receipt = new PrintReceipt();
//        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);
//
//        CashierServiceImpl cashier = new CashierServiceImpl();
//
//        ArrayList<Item> cartProduct = new ArrayList<>();
//        ArrayList<Item> cartProduct1 = new ArrayList<>();
//        ArrayList<Item> cartProduct2 = new ArrayList<>();
//        ArrayList<Item> cartProduct3 = new ArrayList<>();
//
//
//        Customer customer1 = new Customer(1,cartProduct, 100000.0);
//        Customer customer2 = new Customer(2, cartProduct1, 50000.0);
//        Customer customer3 = new Customer(3, cartProduct2, 20000.0);
//        Customer customer4 = new Customer(4, cartProduct3, 300000.0);
//
//
//        CustomerServiceImpl customerService = new CustomerServiceImpl();
//
//        //Add items to customer1 Cart-------------------------------------------------------------------------
//        Item item1 = new Item("milo", 30);
//        Item item2 = new Item("monster", 5);
//        Item item3 = new Item("orijin", 2);
//        Item item4 = new Item("tissue paper", 20);
//
//        customerService.addToCart(store1, item1, customer1);
//        customerService.addToCart(store1, item2, customer1);
//        customerService.addToCart(store1, item3, customer1);
//        customerService.addToCart(store1, item4, customer1);
//
//        //Add items to customer2 Cart-------------------------------------------------------------------------
//        Item item5 = new Item("milk", 30);
//        Item item6 = new Item("spoon", 15);
//        Item item7 = new Item("knife", 2);
//        Item item8 = new Item("sugar", 25);
//
//        customerService.addToCart(store1, item5, customer2);
//        customerService.addToCart(store1, item6, customer2);
//        customerService.addToCart(store1, item7, customer2);
//        customerService.addToCart(store1, item8, customer2);
//
//        //Add items to customer3 Cart-------------------------------------------------------------------------
//        Item item9 = new Item("sanitary pad", 5);
//        Item item10 = new Item("orijin", 10);
//        Item item11 = new Item("milk", 5);
//        Item item12 = new Item("peeler", 2);
//
//        customerService.addToCart(store1, item9, customer3);
//        customerService.addToCart(store1, item10, customer3);
//        customerService.addToCart(store1, item11, customer3);
//        customerService.addToCart(store1, item12, customer3);
//
//        Item item13 = new Item("5alive", 120);
//        Item item14 = new Item("monster", 10);
//        Item item15 = new Item("milk", 5);
//        Item item16 = new Item("peeler", 1);
//
//        customerService.addToCart(store1, item13, customer4);
//        customerService.addToCart(store1, item14, customer4);
//        customerService.addToCart(store1, item15, customer4);
//        customerService.addToCart(store1, item16, customer4);
//
//
//
//        //Setting the Array values to customers Cart-----------------------------------------------------------------------------------
//        customer1.setPurchaseCart(cartProduct);
//        customer2.setPurchaseCart(cartProduct1);
//        customer3.setPurchaseCart(cartProduct2);
//        customer4.setPurchaseCart(cartProduct3);
//
//        //Adding the customers to Priority Queue which is a field in the Store entity (Position in the queue is determined by the number of total quantity)---
//        LinkedList<Customer> custQueue = new LinkedList<>();
//
//
//        custQueue.add(customer1);
//        custQueue.add(customer2);
//        custQueue.add(customer3);
//        custQueue.add(customer4);
//
//        store1.setCustomerQueue2(custQueue);
//
//
//        String expected = "Product sold to customer: 1";
//
//        assertEquals(expected, cashier.sellProduct(store1, staff3, custQueue));
//    }
//
//    @Test
//    void sellProductUnsuccessfulBasedOnFIFO() {
//        Store store1 = new Store();
//        ProductFileReaderService reader = new ProductFileReaderService();
//        store1.setProductsList(reader.productList());
//
//        PrintReceipt receipt = new PrintReceipt();
//        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);
//
//        CashierServiceImpl cashier = new CashierServiceImpl();
//
//        ArrayList<Item> cartProduct = new ArrayList<>();
//        ArrayList<Item> cartProduct1 = new ArrayList<>();
//        ArrayList<Item> cartProduct2 = new ArrayList<>();
//        ArrayList<Item> cartProduct3 = new ArrayList<>();
//
//
//        Customer customer1 = new Customer(1,cartProduct, 1000.0);
//        Customer customer2 = new Customer(2, cartProduct1, 50000.0);
//        Customer customer3 = new Customer(3, cartProduct2, 20000.0);
//        Customer customer4 = new Customer(4, cartProduct3, 300000.0);
//
//
//        CustomerServiceImpl customerService = new CustomerServiceImpl();
//
//        //Add items to customer1 Cart-------------------------------------------------------------------------
//        Item item1 = new Item("milo", 30);
//        Item item2 = new Item("monster", 5);
//        Item item3 = new Item("orijin", 2);
//        Item item4 = new Item("tissue paper", 20);
//
//        customerService.addToCart(store1, item1, customer1);
//        customerService.addToCart(store1, item2, customer1);
//        customerService.addToCart(store1, item3, customer1);
//        customerService.addToCart(store1, item4, customer1);
//
//        //Add items to customer2 Cart-------------------------------------------------------------------------
//        Item item5 = new Item("milk", 30);
//        Item item6 = new Item("spoon", 15);
//        Item item7 = new Item("knife", 2);
//        Item item8 = new Item("sugar", 25);
//
//        customerService.addToCart(store1, item5, customer2);
//        customerService.addToCart(store1, item6, customer2);
//        customerService.addToCart(store1, item7, customer2);
//        customerService.addToCart(store1, item8, customer2);
//
//        //Add items to customer3 Cart-------------------------------------------------------------------------
//        Item item9 = new Item("sanitary pad", 5);
//        Item item10 = new Item("orijin", 10);
//        Item item11 = new Item("milk", 5);
//        Item item12 = new Item("peeler", 2);
//
//        customerService.addToCart(store1, item9, customer3);
//        customerService.addToCart(store1, item10, customer3);
//        customerService.addToCart(store1, item11, customer3);
//        customerService.addToCart(store1, item12, customer3);
//
//        Item item13 = new Item("5alive", 120);
//        Item item14 = new Item("monster", 10);
//        Item item15 = new Item("milk", 5);
//        Item item16 = new Item("peeler", 1);
//
//        customerService.addToCart(store1, item13, customer4);
//        customerService.addToCart(store1, item14, customer4);
//        customerService.addToCart(store1, item15, customer4);
//        customerService.addToCart(store1, item16, customer4);
//
//
//
//        //Setting the Array values to customers Cart-----------------------------------------------------------------------------------
//        customer1.setPurchaseCart(cartProduct);
//        customer2.setPurchaseCart(cartProduct1);
//        customer3.setPurchaseCart(cartProduct2);
//        customer4.setPurchaseCart(cartProduct3);
//
//        //Adding the customers to Priority Queue which is a field in the Store entity (Position in the queue is determined by the number of total quantity)---
//        LinkedList<Customer> custQueue = new LinkedList<>();
//
//
//        custQueue.add(customer1);
//        custQueue.add(customer2);
//        custQueue.add(customer3);
//        custQueue.add(customer4);
//
//        store1.setCustomerQueue2(custQueue);
//
//
//        String expected = "Insufficient balance to sell to Customer: 1";
//
//        assertEquals(expected, cashier.sellProduct(store1, staff3, custQueue));
//    }
//}