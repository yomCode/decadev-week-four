package models;

import Interfaces.CashierInterface;
import Interfaces.ManagerInterface;
import enums.Qualification;
import enums.Role;
import enums.Sex;
import exceptions.AccessDenialException;

public class Staff extends Person {

    private Role role;


    //CONSTRUCTOR----------------------------

    //No Args
    public  Staff(){

    }

    //All Args

    public Staff(Role role) {
        this.role = role;
    }

    public Staff(Integer id, String name, Integer age, Sex sex, Qualification qualification, String email, Role role) {
        super(id, name, age, sex, qualification, email);
        this.role = role;
    }

    public Staff(Integer id, String name, Integer age, Sex sex, Qualification qualification, String email) {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Staff{" +
                "role=" + role +
                '}';
    }

}
