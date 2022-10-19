
import enums.Qualification;
import enums.Role;
import enums.Sex;
import models.*;
import services.CashierServiceImpl;
import services.CustomerServiceImpl;
import services.ManagerServiceImpl;

import java.util.LinkedList;


public class Main {
    public static void main(String[] args)  {

        //Instances of a staff Class------------------------------------------------------------------------------------------->
        Staff staff1 = new Staff( 12,"Hakeem Adewale", 45, Sex.MALE, Qualification.MSC, "Adewale@gmail.com", Role.MANAGER);
        Staff staff2 = new Staff ( 323, "Adeola Johnson", 20, Sex.FEMALE, Qualification.BSC, "Adeola123@gmail.com", Role.CASHIER);
        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);

        ManagerServiceImpl manager = new ManagerServiceImpl();


        //Instances of Applicants-------------------------------------------------------------------------------------------------
        Applicant applicant1 = new Applicant(2332, "Ronke George", 26, Sex.FEMALE, Qualification.HND,
                "rony123@gmail.com", 86.0, 3);

        Applicant applicant2 = new Applicant(2322, "John Banks", 25, Sex.MALE, Qualification.BSC,
                "john123@gmail.com", 83.5, 3);

        //Instance of the Store-----------------------------------------------------------------------------
        Store store1 = new Store(212, "Ugo Mini Store");


        //CALL THE METHOD TO READ PRODUCT FILE-----------------------------------------------------------------
        ProductFileReaderService read = new ProductFileReaderService();
        store1.setProductsList(read.productList());


        //Customer instances-------------------------------------------------------------------------------------

        Customer customer1 = new Customer(1,"milo", 500000.0, 10);
        Customer customer2 = new Customer(2, "milo", 50000.0, 10);
        Customer customer3 = new Customer(3, "milo", 20000.0, 10);
        Customer customer4 = new Customer(4, "milo", 300000.0, 20);

        LinkedList<CustomerServiceImpl> customerThreadList = new LinkedList<>();

        CustomerServiceImpl customerService1 = new CustomerServiceImpl(customer1, store1);
        CustomerServiceImpl customerService2 = new CustomerServiceImpl(customer2, store1);
        CustomerServiceImpl customerService3 = new CustomerServiceImpl(customer3, store1);
        CustomerServiceImpl customerService4 = new CustomerServiceImpl(customer4, store1);


//        Thread customerThread1 = new Thread(customerService1);
//        Thread customerThread2 = new Thread(customerService2);
//        Thread customerThread3 = new Thread(customerService3);
//        Thread customerThread4 = new Thread(customerService4);

        customerThreadList.add(customerService1);
        customerThreadList.add(customerService2);
        customerThreadList.add(customerService3);
        customerThreadList.add(customerService4);

//        customerThread1.start();
//        customerThread2.start();
//        customerThread3.start();
//        customerThread4.start();

        for(int i = 0; i< customerThreadList.size(); i++){
            CustomerServiceImpl eachCustomerService = customerThreadList.get(i);
            eachCustomerService.start();

            Thread cashierThread = new Thread(new CashierServiceImpl(store1, staff2, eachCustomerService.getCustomer(), eachCustomerService){

                @Override
                public void run(){
                    try {
                        eachCustomerService.join();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });

            cashierThread.start();

        }


//        Thread cashierThread1 = new Thread(new CashierServiceImpl(store1, staff2, customer1, customerService1));
//        Thread cashierThread2 = new Thread(new CashierServiceImpl(store1, staff2, customer2, customerService2));
//        Thread cashierThread3 = new Thread(new CashierServiceImpl(store1, staff2, customer3, customerService3));
//        Thread cashierThread4 = new Thread(new CashierServiceImpl(store1, staff2, customer4, customerService4));
//
//        cashierThread1.start();
//        cashierThread2.start();
//        cashierThread3.start();
//        cashierThread4.start();


//        for(Products x : store1.getProductsList() ){
//            System.out.println(x);
//        }
    }
}
