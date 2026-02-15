package com.codingshuttle.youtube.demo.Service;

import com.codingshuttle.youtube.demo.Entity.Appointment;
import com.codingshuttle.youtube.demo.Entity.Doctors;
import com.codingshuttle.youtube.demo.Entity.Patient;
import com.codingshuttle.youtube.demo.Repository.AppointmentRepository;
import com.codingshuttle.youtube.demo.Repository.DoctorsRepository;
import com.codingshuttle.youtube.demo.Repository.PateintRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service@RequiredArgsConstructor
public class AppointmentService {


    private  final AppointmentRepository appointmentRepository;
    private  final DoctorsRepository doctorsRepository;
    private  final PateintRepository pateintRepository;


    @Transactional
    public Appointment createNewAppointment (Appointment appointment , Long doctorId , Long patientID){
        Doctors doctors = doctorsRepository.findById(doctorId).orElseThrow(()-> new IllegalArgumentException());
        Patient patient = pateintRepository.findById(patientID).orElseThrow(()-> new IllegalArgumentException());

        if (appointment.getId() != null ) throw new IllegalArgumentException( "Appointment should not have ");

        appointment.setPatient( patient);
        appointment.setDoctors(doctors);

        patient.getAppointmentList().add(appointment);


      return appointmentRepository.save(appointment);

    }


    @Transactional
    public Appointment reasignAppointmentToAnotherDoctore(Long appointmentId , Long DoctorID  ){

        Doctors doctors = doctorsRepository.findById(DoctorID).orElseThrow(()-> new IllegalArgumentException());
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(()-> new IllegalArgumentException());

        appointment.setDoctors(doctors);  // automaticaly call the update operation

        doctors.getAppointments().add(appointment);
         //  just for biderctional consistency

        return appointment;



    }

}
