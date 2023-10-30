package com.StudentManagmentSystem.demo.repository;

import com.StudentManagmentSystem.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
