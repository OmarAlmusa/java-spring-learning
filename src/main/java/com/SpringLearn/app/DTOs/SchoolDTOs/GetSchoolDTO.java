package com.SpringLearn.app.DTOs.SchoolDTOs;

import com.SpringLearn.app.DTOs.StudentDTOs.GetStudentDTO;

import java.util.List;

public record GetSchoolDTO(
        Integer id,
        String schoolName,
        List<GetStudentDTO> students
) {
}
