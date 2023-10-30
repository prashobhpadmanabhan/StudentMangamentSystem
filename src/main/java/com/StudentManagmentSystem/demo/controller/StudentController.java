package com.StudentManagmentSystem.demo.controller;

import com.StudentManagmentSystem.demo.contract.StudentRequest;
import com.StudentManagmentSystem.demo.contract.StudentResponse;
import com.StudentManagmentSystem.demo.model.Student;
import com.StudentManagmentSystem.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    public StudentService studentService;

    public StudentController(StudentService studentService)
    {this.studentService = studentService;}

    @GetMapping("/get")
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }
    @PostMapping("/create")
    public ResponseEntity<Long>createStudent(@RequestBody StudentRequest studentRequest)
    {
        return ResponseEntity.ok(studentService.createStudent(studentRequest));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentResponse> getStudentByLd(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }


     @PutMapping("/updateStudentById/{id}")
    public Student updateStudentById(@PathVariable Long id, @RequestBody StudentRequest studentRequest)
     {
         return studentService.updateStudentById(id,studentRequest);
     }
    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id,@RequestBody StudentRequest studentRequest)
    {
        return studentService.deleteStudentById(id);
    }

}
