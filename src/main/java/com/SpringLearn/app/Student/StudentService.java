package com.SpringLearn.app.Student;

import com.SpringLearn.app.School.School;
import com.SpringLearn.app.School.SchoolRepository;
import com.SpringLearn.app.Student.StudentDTOs.CreateStudentDTO;
import com.SpringLearn.app.Student.StudentDTOs.GetStudentDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, SchoolRepository schoolRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
        this.studentMapper = studentMapper;
    }

    public GetStudentDTO addStudent(
            CreateStudentDTO studentPostDTO
    ){
        Student student = studentMapper.toStudent(studentPostDTO);

        if (studentPostDTO.school_id() != null){
            School school = schoolRepository.findById(studentPostDTO.school_id())
                    .orElseThrow(()-> new EntityNotFoundException("School with ID " + studentPostDTO.school_id() + " not found"));

            student.setSchool(school);
        }

        Student savedStudent = studentRepository.save(student);

        return studentMapper.toStudentGetDTO(savedStudent);
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
//        Student foundStudent = studentRepository.findById(studentId).orElse(new Student());
//        return studentMapper.toStudentGetDTO(foundStudent);
        return studentRepository.findById(studentId)
                .map(studentMapper::toStudentGetDTO)
                .orElseThrow(()-> new EntityNotFoundException("Student with ID " + studentId + " not found"));
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
