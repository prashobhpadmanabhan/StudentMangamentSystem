package com.StudentManagmentSystem.demo.service;

import com.StudentManagmentSystem.demo.contract.StudentRequest;
import com.StudentManagmentSystem.demo.contract.StudentResponse;
import com.StudentManagmentSystem.demo.model.Student;
import com.StudentManagmentSystem.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Long createStudent(StudentRequest student) {
        Student response = Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .courses(student.getCourses())
                .departmentId(student.getDepartmentId())
                .build();
        response = studentRepository.save(response);
        return response.getId();
    }

    public StudentResponse getStudentById(Long id){
        Student response = studentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Student not found"));
        return StudentResponse.builder()
                .id(response.getId())
                .firstName(response.getFirstName())
                .lastName(response.getLastName())
                .email(response.getEmail())
                .courses(response.getCourses())
                .departmentId(response.getDepartmentId())
                .build();
    }

    public List<Student> getAllStudent(){
        List<Student> response = studentRepository.findAll();
        return response;
    }
    public Student updateStudentById(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id).orElse(null);
        student = Student.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .courses(student.getCourses())
                .departmentId(student.getDepartmentId())
                .build();
        return student;

    }

    public String deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return null;
    }
}


