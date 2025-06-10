package com.SpringLearn.app.Student;


import com.SpringLearn.app.Student.StudentDTOs.CreateStudentDTO;
import com.SpringLearn.app.Student.StudentDTOs.GetStudentDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public GetStudentDTO addStudent(
            @Valid @RequestBody CreateStudentDTO studentPostDTO
    ){
        return this.studentService.addStudent(studentPostDTO);
    }

    @GetMapping("/students")
    public List<GetStudentDTO> getAllStudents(){
        return this.studentService.getAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public GetStudentDTO getStudentById(
            @PathVariable("student-id") Integer studentId
    ){
        return this.studentService.getStudentById(studentId);
    }

    @GetMapping("/students/search/{student-name}")
    public List<GetStudentDTO> getStudentByName(
            @PathVariable("student-name") String studentName
    ){
        return this.studentService.getStudentByName(studentName);
    }

    @DeleteMapping("/students/{student-id}")
    public void deleteStudentById(
            @PathVariable("student-id") Integer studentId
    ){
        this.studentService.deleteStudentById(studentId);
    }
}
