
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

        Customer customer1 = new Customer(1,"sugar", 500000.0, 20);
        Customer customer2 = new Customer(2, "sugar", 50000.0, 10);
        Customer customer3 = new Customer(3, "sugar", 20000.0, 10);
        Customer customer4 = new Customer(4, "sugar", 300000.0, 20);

        LinkedList<CustomerServiceImpl> customerList = new LinkedList<>();
        store1.setCustomerQueue(customerList);

        customerList.add(new CustomerServiceImpl(customer1, store1));
        customerList.add(new CustomerServiceImpl(customer2, store1));
        customerList.add(new CustomerServiceImpl(customer3, store1));
        customerList.add(new CustomerServiceImpl(customer4, store1));


       for(int i = 0; i < store1.getCustomerQueue().size(); i++){
           Thread cashierThread = new Thread(
                   new CashierServiceImpl(store1, staff2, customerList.get(i).getCustomer(), customerList.get(i)));

           cashierThread.start();
           try {
               cashierThread.join();
           }catch(InterruptedException e){
               e.printStackTrace();
           }
       }

       customerList.clear();


    }
}
