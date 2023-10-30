package com.StudentManagmentSystem.demo.controller;


import com.StudentManagmentSystem.demo.contract.StudentRequest;
import com.StudentManagmentSystem.demo.model.Student;
import com.StudentManagmentSystem.demo.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testAddStudent(){
        Student student = new Student();
        assertNull(student.getId());
        student.setId(1L);
        assertNotNull(student.getId());
        assertEquals("firstName",student.getFirstName());
        assertEquals("lastName",student.getLastName());
        assertEquals("email",student.getEmail());
        assertEquals("courses",student.getCourses());
        assertEquals("DepartmentId",student.getDepartmentId());

    }

    @Test
    public void testGetStudentById() throws Exception{
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("J");
        student.setLastName("Z");
        student.setEmail("JZ@gmail.com");
        student.setCourses("a");
        student.setDepartmentId(2L);
         when(studentService.getStudentById(student.getId())).thenReturn(student);

         mockMvc.perform(get("/student/1")).andExpect(status().isOk());}

    @Test
    public void testGetAllStudents() throws Exception{
        Student student =new Student();
        student.setId(1L);
        student.setFirstName("J");
        student.setLastName("Z");
        student.setEmail("JZ@gmail.com");
        student.setCourses("a");
        student.setDepartmentId(2L);
        List<Student>studentList = new ArrayList<>();
        studentList.add(student);

        when(studentService.getAllStudent()).thenReturn(studentList);
        mockMvc.perform(get("/student")).andExpect(status().isOk());

    }
    @Test
    public void testDeleteStudent() throws Exception {
        doNothing().when(studentService).deleteStudentById(1L);
        mockMvc.perform(delete("/student/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testUpdateStudent() throws Exception{
        StudentRequest studentRequest = new StudentRequest("J","Z","JZ@gmail.com",2L,"a");

        when(studentService.updateStudentById(1L, studentRequest)).thenReturn(true);
        mockMvc.perform(put("/student/1"))
                .andExpect(status().isOk());
}}