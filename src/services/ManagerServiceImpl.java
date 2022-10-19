package services;

import Interfaces.ManagerInterface;
import enums.Qualification;
import enums.Role;
import enums.Sex;
import exceptions.AccessDenialException;
import models.Applicant;
import models.Staff;

public class ManagerServiceImpl implements ManagerInterface {

    @Override
    public String hireCashier(Staff staff, Applicant applicant){

        if(staff.getRole().equals(Role.MANAGER)){
            if((applicant.getAge() >= 23 && applicant.getAge()<= 30)
                    && applicant.getSex().equals(Sex.FEMALE)
                    && (applicant.getQualification().equals(Qualification.BSC)
                    || applicant.getQualification().equals(Qualification.HND))
                    && applicant.takeExam().equals("Passed")){
                return "You are hired!";
            }else{

                return "Sorry, you are not qualified for this position.";
            }

        }else{
            throw new AccessDenialException("Access Denied");
        }

    }
}
