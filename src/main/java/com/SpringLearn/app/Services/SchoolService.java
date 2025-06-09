package com.SpringLearn.app.Services;

import com.SpringLearn.app.DTOs.SchoolDTOs.CreateSchoolDTO;
import com.SpringLearn.app.DTOs.SchoolDTOs.GetSchoolDTO;
import com.SpringLearn.app.Entities.School;
import com.SpringLearn.app.Mappers.SchoolMapper;
import com.SpringLearn.app.Repositories.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
        schoolRepository.deleteById(schoolId);
    }
}
