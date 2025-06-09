package com.SpringLearn.app.DTOs.StudentDTOs;

import com.SpringLearn.app.Entities.School;

public record CreateStudentDTO(
        String firstName,
        String lastName,
        String email,
        int age,
        School school
) {

}
