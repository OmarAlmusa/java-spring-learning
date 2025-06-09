package com.SpringLearn.app.Controllers;

import com.SpringLearn.app.DTOs.SchoolDTOs.CreateSchoolDTO;
import com.SpringLearn.app.DTOs.SchoolDTOs.GetSchoolDTO;
import com.SpringLearn.app.Services.SchoolService;
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
            @RequestBody CreateSchoolDTO schoolPostDTO
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
