package com.SpringLearn.app.School;

import com.SpringLearn.app.Student.StudentMapper;
import com.SpringLearn.app.School.SchoolDTOs.CreateSchoolDTO;
import com.SpringLearn.app.School.SchoolDTOs.GetSchoolDTO;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class SchoolMapper {

    private final StudentMapper studentMapper;

    public SchoolMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public School toSchool(CreateSchoolDTO schoolPostDTO) {
        var school = new School();
        school.setSchoolName(schoolPostDTO.schoolName());
        return school;
    }

    public CreateSchoolDTO toSchoolCreateDTO(School school){
        return new CreateSchoolDTO(school.getSchoolName());
    }

    public GetSchoolDTO toSchoolGetDTO(School school){
        return new GetSchoolDTO(
                school.getId(),
                school.getSchoolName(),
                school.getStudents()
                        .stream()
                        .map(this.studentMapper::toStudentGetDTO)
                        .collect(Collectors.toList())
        );
    }
}
