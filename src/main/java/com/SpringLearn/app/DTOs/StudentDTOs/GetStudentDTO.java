package com.SpringLearn.app.DTOs.StudentDTOs;

public record GetStudentDTO(
        String firstName,
        String lastName,
        Integer school_id
) {
}
