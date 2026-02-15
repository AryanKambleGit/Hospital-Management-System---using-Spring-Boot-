package com.codingshuttle.youtube.demo.Service;


import com.codingshuttle.youtube.demo.Entity.Insurance;
import com.codingshuttle.youtube.demo.Entity.Patient;
import com.codingshuttle.youtube.demo.Repository.InsuranceRepository;
import com.codingshuttle.youtube.demo.Repository.PateintRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.RecursiveTask;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PateintRepository pateintRepository;


    @Transactional   // sab perform hoge ya roll back hoga
    public Patient assignInsuranceToPatient(Insurance insurance , Long patientID){
        Patient patient = pateintRepository.findById(patientID)
                .orElseThrow(()->new IllegalArgumentException());

        patient.setInsurance(insurance);
        insurance.setPatient(patient);  //bidrirectional consiteny maintain rahe

        return patient;
    }


    @Transactional
    public Patient dessociateInsuranceFromPatient (Long patientId){
        Patient patient = pateintRepository.findById(patientId)
                .orElseThrow(()->new IllegalArgumentException());

        patient.setInsurance(null);
        return patient;

    }

}
