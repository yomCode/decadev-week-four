package models;

import enums.Qualification;
import enums.Sex;

public class Applicant extends Person{
    private Double examScore;
    private Integer yearsOfExperience;


    public Applicant(){

    }


    public Applicant(Double examScore, Integer yearsOfExperience) {
        this.examScore = examScore;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Applicant(Integer id, String name, Integer age, Sex sex, Qualification qualification, String email, Double examScore, Integer yearsOfExperience) {
        super(id, name, age, sex, qualification, email);
        this.examScore = examScore;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Applicant(Integer id, Double examScore, Integer yearsOfExperience) {
        super(id);
        this.examScore = examScore;
        this.yearsOfExperience = yearsOfExperience;
    }



    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Double getExamScore() {
        return examScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }


    @Override
    public String toString() {
        return "Applicant{" +
                "examScore=" + examScore +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }

    public String takeExam(){
        if(getExamScore() >= 85){
            return "Passed";
        }else{
            return "Failed";
        }

    }
}
