package com.codingshuttle.youtube.demo.Repository;

import com.codingshuttle.youtube.demo.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}