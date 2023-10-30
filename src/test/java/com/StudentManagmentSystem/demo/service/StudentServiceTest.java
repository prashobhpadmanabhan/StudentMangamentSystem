package com.StudentManagmentSystem.demo.service;

import com.StudentManagmentSystem.demo.contract.StudentRequest;
import com.StudentManagmentSystem.demo.contract.StudentResponse;
import com.StudentManagmentSystem.demo.model.Student;
import com.StudentManagmentSystem.demo.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class StudentServiceTest {
    private StudentRepository studentRepository;
    private StudentService studentService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        studentService = new StudentService(studentRepository);
    }

    @Test
    void testGetAllCourses(){
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("J");
        student.setLastName("Z");
        student.setCourses("a");
        student.setEmail("JZ@gmail.com");
        student.setDepartmentId(2L);
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student);
        when(studentRepository.findAll()).thenReturn(studentList);
        List<Student> items = studentService.getAllStudent();
        assertEquals(items.get(0).getId(),1L);
    }

    @Test
    void testGetCourseById(){
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("J");
        student.setLastName("Z");
        student.setCourses("a");
        student.setEmail("JZ@gmail.com");
        student.setDepartmentId(2L);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        StudentResponse student1 = studentService.getStudentById(1L);
        assertEquals(student1.getId(),1L);
    }


    @Test
    void testAddCourse(){
        StudentRequest studentRequest = new StudentRequest("J","Z","JZ@gmail.com",2L,"a");
//        studentRequest.setId(1L);
//        studentRequest.setFirstName("J");
//        studentRequest.setLastName("Z");
//        studentRequest.setEmail("JZ@gmail.com");
//        studentRequest.setCourses("a");
//        studentRequest.setDepartmentId(2L);
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("J");
        student.setLastName("Z");
        student.setCourses("a");
        student.setEmail("JZ@gmail.com");
        student.setDepartmentId(2L);
        when(studentRepository.save(student)).thenReturn(student);
        Student id = studentService.createStudent(studentRequest);
        assertEquals(id.getId(),1L);
    }




    @Test
    void testDeleteStudent(){
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("J");
        student.setLastName("Z");
        student.setCourses("a");
        student.setEmail("JZ@gmail.com");
        student.setDepartmentId(2L);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        Boolean item = Boolean.valueOf(studentService.deleteStudentById(1L));
        Mockito.verify(studentRepository).deleteById(1L);
    }
    }



