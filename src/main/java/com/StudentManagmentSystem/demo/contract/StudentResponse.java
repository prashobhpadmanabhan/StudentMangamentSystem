package com.StudentManagmentSystem.demo.contract;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponse {

        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private Long departmentId;
        private String courses;

    }


