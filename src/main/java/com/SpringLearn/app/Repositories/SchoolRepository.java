package com.SpringLearn.app.Repositories;


import com.SpringLearn.app.Entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
