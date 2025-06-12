package com.SpringLearn.app.Student;

import com.SpringLearn.app.School.School;
import com.SpringLearn.app.Student.StudentDTOs.CreateStudentDTO;
import com.SpringLearn.app.Student.StudentDTOs.GetStudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;
    private School school;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
        school = new School();
    }

    @Test
    public void testToStudentGetDTO(){
         Student student = new Student();
         student.setFirstName("Mark");
         student.setLastName("jj");
         student.setSchool(this.school);

        GetStudentDTO studentDTO = mapper.toStudentGetDTO(student);

        assertEquals(studentDTO.firstName(), student.getFirstName());
        assertEquals(studentDTO.lastName(), student.getLastName());
        assertEquals(studentDTO.school_id(), student.getSchool().getId());
    }

    @Test
    public void testToStudent(){
        CreateStudentDTO studentDTO = new CreateStudentDTO(
                "Kelly",
                "Johnson",
                "kjohn98@gmail.com",
                23,
                this.school.getId()
        );

        Student student = mapper.toStudent(studentDTO);
        student.setSchool(this.school);

        assertEquals(student.getFirstName(), studentDTO.firstName());
        assertEquals(student.getLastName(), studentDTO.lastName());
        assertEquals(student.getEmail(), studentDTO.email());
        assertEquals(student.getAge(), studentDTO.age());
        assertEquals(student.getSchool().getId(), studentDTO.school_id());
    }

}