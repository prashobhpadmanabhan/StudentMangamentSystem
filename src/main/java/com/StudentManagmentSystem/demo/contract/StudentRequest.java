package com.StudentManagmentSystem.demo.contract;

import lombok.Getter;

public class StudentRequest {
    private String firstName;
    private String lastName;
    private  String email;
    private Long departmentId;
    private String courses;
    @Getter
    private Long id;

    public StudentRequest(String firstName, String lastName, String email, Long departmentId, String courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departmentId = departmentId;
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {return email;}


    public void setEmail(String email) {
        this.email = email;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
