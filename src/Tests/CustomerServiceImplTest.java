//package Tests;
//
//import models.*;
//import org.junit.jupiter.api.Test;
//import services.CustomerServiceImpl;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CustomerServiceImplTest {
//
//    Store store = new Store();
//
//    @Test
//    void addToCartSuccessful() {
//        ProductFileReaderService reader = new ProductFileReaderService();
//         store.setProductsList(reader.productList());
//
//        ArrayList<Item> cartProduct = new ArrayList<>();
//
//        Customer customer1 = new Customer(1,cartProduct, 100000.0);
//        CustomerServiceImpl customerService = new CustomerServiceImpl();
//
//        Item item1 = new Item("milo", 30);
//
//        String expected = "milo added to cart successfully";
//        assertEquals(expected, customerService.addToCart(store, item1, customer1));
//
//    }
//
//    @Test
//    void addToCartUnsuccessful() {
//        ProductFileReaderService reader = new ProductFileReaderService();
//        store.setProductsList(reader.productList());
//
//        ArrayList<Item> cartProduct = new ArrayList<>();
//
//        Customer customer1 = new Customer(1,cartProduct, 100000.0);
//        CustomerServiceImpl customerService = new CustomerServiceImpl();
//
//        Item item1 = new Item("mili", 30);
//
//        String expected = "Product is currently unavailable";
//        assertEquals(expected, customerService.addToCart(store, item1, customer1));
//
//    }
//
//}