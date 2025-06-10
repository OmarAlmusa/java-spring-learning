package com.SpringLearn.app.Student;

import com.SpringLearn.app.Student.StudentDTOs.CreateStudentDTO;
import com.SpringLearn.app.Student.StudentDTOs.GetStudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public GetStudentDTO addStudent(
            CreateStudentDTO studentPostDTO
    ){
        Student student = studentMapper.toStudent(studentPostDTO);
        studentRepository.save(student);
        GetStudentDTO studentGetDTO = studentMapper.toStudentGetDTO(student);
        return studentGetDTO;
    }

    public List<GetStudentDTO> getAllStudents(){
        return studentRepository
                .findAll()
                .stream()
                .map(studentMapper::toStudentGetDTO)
                .collect(Collectors.toList());
    }

    public GetStudentDTO getStudentById(
            Integer studentId
    ){
        Student foundStudent = studentRepository.findById(studentId).orElse(new Student());
        return studentMapper.toStudentGetDTO(foundStudent);
    }

    public List<GetStudentDTO> getStudentByName(
            String studentName
    ){
        return studentRepository.findAllByFirstNameContaining(studentName)
                .stream()
                .map(studentMapper::toStudentGetDTO)
                .collect(Collectors.toList());
    }

    public void deleteStudentById(
            Integer studentId
    ){
        studentRepository.deleteById(studentId);
    }
}
