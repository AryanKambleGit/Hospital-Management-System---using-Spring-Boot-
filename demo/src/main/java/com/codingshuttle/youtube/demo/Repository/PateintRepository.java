package com.codingshuttle.youtube.demo.Repository;

import com.codingshuttle.youtube.demo.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PateintRepository extends JpaRepository<Patient, Long > {

    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateBetween(LocalDate birthDateAfter, LocalDate birthDateBefore);

    List<Patient> findByNameContaining(String name);

}
