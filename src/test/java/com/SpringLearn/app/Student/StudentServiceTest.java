package com.SpringLearn.app.Student;

import com.SpringLearn.app.School.School;
import com.SpringLearn.app.School.SchoolRepository;
import com.SpringLearn.app.Student.StudentDTOs.CreateStudentDTO;
import com.SpringLearn.app.Student.StudentDTOs.GetStudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private SchoolRepository schoolRepository;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    private School school;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        school = new School();
    }

    @Test
    public void testAddStudent(){
        CreateStudentDTO studentPostDTO = new CreateStudentDTO(
                "John",
                "Smart",
                "js@gmail.net",
                27,
                this.school.getId()
        );

        Student student = new Student();

        student.setFirstName("John");
        student.setLastName("Smart");
        student.setEmail("js@gmail.net");
        student.setAge(27);
        student.setSchool(this.school);

        GetStudentDTO studentGetDTO = new GetStudentDTO(
                "John",
                "Smart",
                this.school.getId()
        );

        when(studentMapper.toStudent(studentPostDTO)).thenReturn(student);
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        when(studentMapper.toStudentGetDTO(student)).thenReturn(studentGetDTO);

        GetStudentDTO result = studentService.addStudent(studentPostDTO);

        assertNotNull(result);
        assertEquals(studentGetDTO.firstName(), result.firstName());
        assertEquals(studentGetDTO.lastName(), result.lastName());
        assertEquals(studentGetDTO.school_id(), result.school_id());

        verify(studentMapper, times(1)).toStudent(studentPostDTO);
        verify(studentRepository, times(1)).save(any(Student.class));
        verify(studentMapper, times(1)).toStudentGetDTO(student);

    }
}