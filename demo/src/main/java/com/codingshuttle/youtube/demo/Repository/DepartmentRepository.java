package com.codingshuttle.youtube.demo.Repository;

import com.codingshuttle.youtube.demo.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}