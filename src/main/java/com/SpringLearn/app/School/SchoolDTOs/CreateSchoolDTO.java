package com.SpringLearn.app.School.SchoolDTOs;

import jakarta.validation.constraints.NotEmpty;

public record CreateSchoolDTO(
        @NotEmpty
        String schoolName
) {
}
