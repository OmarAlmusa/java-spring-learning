package com.SpringLearn.app.School.SchoolDTOs;

import com.SpringLearn.app.Student.StudentDTOs.GetStudentDTO;

import java.util.List;

public record GetSchoolDTO(
        Integer id,
        String schoolName,
        List<GetStudentDTO> students
) {
}
