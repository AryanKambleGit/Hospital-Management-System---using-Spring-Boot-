package com.codingshuttle.youtube.demo;

import com.codingshuttle.youtube.demo.Entity.Appointment;
import com.codingshuttle.youtube.demo.Entity.Insurance;
import com.codingshuttle.youtube.demo.Entity.Patient;
import com.codingshuttle.youtube.demo.Repository.PateintRepository;
import com.codingshuttle.youtube.demo.Service.AppointmentService;
import com.codingshuttle.youtube.demo.Service.InsuranceService;
import org.glassfish.jaxb.runtime.v2.schemagen.xmlschema.Appinfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {


    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PateintRepository pateintRepository;


    @Test
    public  void  testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("Hdfc Emwiay")
                .provider("Obv Hdfc")
                .validUntil(LocalDate.of(2007 ,  4 ,3)).build();


      Patient patient =  insuranceService.
                                                                                                                                                  assignInsuranceToPatient(insurance , 1L);
        System.out.println(patient);

      var newPatient=  insuranceService.dessociateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);
    }

//
//    @Test
//    public void createAppointment(){
//        Appointment appointment = Appointment.builder()
//                .appointmentTime(LocalDateTime.of(2026, 11 , 2 , 14,0,2 ))
//                .reason("cancer")
//                .build();
//        Appointment appointment1 = Appointment.builder()
//                .appointmentTime(LocalDateTime.of(2026, 11 , 2 , 14,0,2 ))
//                .reason("cdhs")
//                .build();
//        var newAppointment  = appointmentService.createNewAppointment(appointment, 1L ,2L);
//        var newA = appointmentService.createNewAppointment(appointment1 , 1L , 2L);
//
//
//
//    }
@Test
@Transactional
public void createAppointment() {

    // create 2 appointments for same patient
    Appointment appointment = Appointment.builder()
            .appointmentTime(LocalDateTime.of(2026, 11 , 2 , 14,0,2))
            .reason("cancer")
            .build();

    Appointment appointment1 = Appointment.builder()
            .appointmentTime(LocalDateTime.of(2026, 11 , 2 , 14,0,2))
            .reason("cdhs")
            .build();

    appointmentService.createNewAppointment(appointment, 1L, 2L);
    appointmentService.createNewAppointment(appointment1, 1L, 2L);

    // delete patient
    pateintRepository.deleteById(2L);

    pateintRepository.flush();

}






    @Test
    public void  AppointTest(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 11 , 2 , 14,0,2 ))
                .reason("cancer")
                .build();



      var newAppointment =   appointmentService.createNewAppointment(appointment, 2L , 1L);
        System.out.println(newAppointment);


       var updatedAppointement  = appointmentService.reasignAppointmentToAnotherDoctore(newAppointment.getId(), 3L);
        System.out.println(updatedAppointement);

    }

}
