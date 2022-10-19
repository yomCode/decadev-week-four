package Tests;

import enums.Qualification;
import enums.Sex;
import models.Applicant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicantTest {

    Applicant applicant1 = new Applicant(2332, "Ronke George", 26, Sex.FEMALE, Qualification.HND,
            "rony123@gmail.com", 86.0, 3);
    Applicant applicant2 = new Applicant(2322, "John Banks", 25, Sex.MALE, Qualification.BSC,
            "john123@gmail.com", 83.5, 3);


    @Test
    void applicantPassedExam() {

        String expected = "Passed";
        String actual = applicant1.takeExam();

        assertEquals(expected, actual);

    }


    @Test
    void applicantFailedExam() {

        String expected = "Failed";
        String actual = applicant2.takeExam();

        assertEquals(expected, actual);

    }
}