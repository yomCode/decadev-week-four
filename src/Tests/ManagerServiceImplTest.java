package Tests;

import enums.Qualification;
import enums.Role;
import enums.Sex;
import models.*;
import org.junit.jupiter.api.Test;
import services.ManagerServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class ManagerServiceImplTest {

    //Staff instances--------------------------------------------------------------------------------------------------------------->
    Staff staff1 = new Staff( 12,"Hakeem Adewale", 45, Sex.MALE, Qualification.MSC, "Adewale@gmail.com", Role.MANAGER);
    Staff staff2 = new Staff ( 323, "Adeola Johnson", 20, Sex.FEMALE, Qualification.BSC, "Adeola123@gmail.com", Role.CASHIER);

    ManagerServiceImpl managerService = new ManagerServiceImpl();

    //Applicant instances--------------------------------------------------------------------------------------------------------------->
    Applicant applicant1 = new Applicant(2332, "Ronke George", 26, Sex.FEMALE, Qualification.HND,
            "rony123@gmail.com", 86.0, 3);
    Applicant applicant2 = new Applicant(2322, "John Banks", 25, Sex.MALE, Qualification.BSC,
            "john123@gmail.com", 83.5, 3);

    //Products instances--------------------------------------------------------------------------------------------------------------->
    Store newStore = new Store();

    PrintReceipt receipt = new PrintReceipt();

    @Test
    void cashierIsHired(){
        String expected = "You are hired!";
        String actual = managerService.hireCashier(staff1, applicant1);

        assertEquals(expected, actual);
    }

    @Test
    void cashierIsNotHiredBasedOnExam(){
        String expected = "Sorry, you are not qualified for this position.";
        String actual = managerService.hireCashier(staff1, applicant2);

        assertEquals(expected, actual);
    }

//    @Test
//    void cashiertHireAccessDenied(){
//        String expected =  "Access Denied!";
//        String actual = managerService.hireCashier(staff2, applicant1);
//
//        assertEquals(expected, actual);
//    }

}