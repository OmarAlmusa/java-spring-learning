package com.SpringLearn.app.Student;

import com.SpringLearn.app.Student.StudentDTOs.CreateStudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void testToStudentGetDTO(){
        CreateStudentDTO studentDTO = new CreateStudentDTO(
                "Kelly",
                "Johnson",
                "kjohn98@gmail.com",
                23,
                1
        );
    }
}