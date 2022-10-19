package models;

import enums.Qualification;
import enums.Sex;

public abstract class Person {
    //ENTITY FIELDS-------------------------
    private Integer id;
    private String name;
    private Integer age;
    private Sex sex;
    private Qualification qualification;
    private String email;


    public Person() {
    }

    public Person(Integer id, String name, Integer age, Sex sex, Qualification qualification, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.qualification = qualification;
        this.email = email;
    }

    public Person(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", qualification=" + qualification +
                ", email='" + email + '\'' +
                '}';
    }
}
