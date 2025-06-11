package com.SpringLearn.app.Student.StudentDTOs;

import com.SpringLearn.app.School.School;
import jakarta.validation.constraints.NotEmpty;

public record CreateStudentDTO(
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName,
        String email,
        int age,
        Integer school_id
) {

}
