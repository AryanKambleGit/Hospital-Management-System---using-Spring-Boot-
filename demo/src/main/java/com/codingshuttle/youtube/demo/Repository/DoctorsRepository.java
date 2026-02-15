package com.codingshuttle.youtube.demo.Repository;

import com.codingshuttle.youtube.demo.Entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepository extends JpaRepository<Doctors, Long> {
}