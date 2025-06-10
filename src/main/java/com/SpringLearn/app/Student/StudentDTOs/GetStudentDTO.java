package com.SpringLearn.app.Student.StudentDTOs;

public record GetStudentDTO(
        String firstName,
        String lastName,
        Integer school_id
) {
}
