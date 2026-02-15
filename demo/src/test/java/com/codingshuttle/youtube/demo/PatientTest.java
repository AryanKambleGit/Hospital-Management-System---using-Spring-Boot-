package com.codingshuttle.youtube.demo;

import com.codingshuttle.youtube.demo.Entity.Patient;
import com.codingshuttle.youtube.demo.Repository.PateintRepository;
//import org.junit.jupiter.api.AutoClose;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html


@SpringBootTest
public class PatientTest {


    @Autowired
    PateintRepository pateintRepository;



//    @Test
//    public void Pateinttest(){
//        List<Patient> patientList = pateintRepository.findAll();
//        System.out.println(patientList);
//    }

//    @Test
//    public void TestTRansaction(){
////        Patient patientList= pateintRepository.findByName("rahul");
////        System.out.println(patientList);
//
////        List<Patient> patientList = pateintRepository.findByBirthDateOrEmail(LocalDate.of(2001,5,10),"rahul_new@gmail.com");
////        System.out.println(patientList);
//
////        3)
////        List<Patient > patientList = pateintRepository.findByBirthDateBetween(LocalDate.of(1900, 01,12), LocalDate.of(2000,2,2));
//
////        4)\
//            List<Patient > patientList  = pateintRepository.findByNameContaining("r");
//
//
//
//        for (Patient patient : patientList){
//            System.out.println(patientList);
//        }
//
//
//      }
//
}
