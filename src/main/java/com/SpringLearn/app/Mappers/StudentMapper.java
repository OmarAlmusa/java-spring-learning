package com.SpringLearn.app.Mappers;

import com.SpringLearn.app.DTOs.StudentDTOs.CreateStudentDTO;
import com.SpringLearn.app.DTOs.StudentDTOs.GetStudentDTO;
import com.SpringLearn.app.Entities.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public GetStudentDTO toStudentGetDTO(Student student) {

        Integer schoolId = student.getSchool() != null ? student.getSchool().getId() : null;

        return new GetStudentDTO(
                student.getFirstName(),
                student.getLastName(),
                schoolId
        );
    }

    public Student toStudent(CreateStudentDTO studentPostDTO) {
        var student = new Student();
        student.setFirstName(studentPostDTO.firstName());
        student.setLastName(studentPostDTO.lastName());
        student.setEmail(studentPostDTO.email());
        student.setAge(studentPostDTO.age());
        student.setSchool(studentPostDTO.school());
        return student;
    }
}
