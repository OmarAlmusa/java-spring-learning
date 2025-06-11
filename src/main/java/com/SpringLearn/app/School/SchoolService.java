package com.SpringLearn.app.School;

import com.SpringLearn.app.School.SchoolDTOs.CreateSchoolDTO;
import com.SpringLearn.app.School.SchoolDTOs.GetSchoolDTO;
import com.SpringLearn.app.Student.Student;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public CreateSchoolDTO addSchool(
            CreateSchoolDTO schoolPostDTO
    ){
        School school = this.schoolMapper.toSchool(schoolPostDTO);
        schoolRepository.save(school);
        return schoolPostDTO;
    }

    public List<GetSchoolDTO> getAllSchools(){
        return schoolRepository.findAll()
                .stream()
                .map(this.schoolMapper::toSchoolGetDTO)
                .collect(Collectors.toList());
    }

    public void deleteSchool(
            Integer schoolId
    ){
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(()-> new EntityNotFoundException("School with ID " + schoolId + " not found"));
        for(Student student : school.getStudents()){
            student.setSchool(null);
        }
        schoolRepository.deleteById(schoolId);
    }
}
