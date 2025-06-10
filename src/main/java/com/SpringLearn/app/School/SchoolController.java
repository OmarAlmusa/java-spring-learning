package com.SpringLearn.app.School;

import com.SpringLearn.app.School.SchoolDTOs.CreateSchoolDTO;
import com.SpringLearn.app.School.SchoolDTOs.GetSchoolDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public CreateSchoolDTO addSchool(
           @Valid @RequestBody CreateSchoolDTO schoolPostDTO
    ){
        return this.schoolService.addSchool(schoolPostDTO);
    }

    @GetMapping("/schools")
    public List<GetSchoolDTO> getAllSchools(){
        return this.schoolService.getAllSchools();
    }

    @DeleteMapping("/schools/{school-id}")
    public void deleteSchool(
            @PathVariable("school-id") Integer schoolId
    ){
        this.schoolService.deleteSchool(schoolId);
    }
}
