package com.SpringLearn.app.School;

import com.SpringLearn.app.Student.Student;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class School {

    @Id
    @GeneratedValue
    private Integer id;

    private String schoolName;

    @OneToMany(
            mappedBy = "school",
            cascade = CascadeType.ALL
    )
    private List<Student> students;

    public School() {
    }

    public School(
            String schoolName,
            List<Student> students
    ) {
        this.schoolName = schoolName;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Integer getId() {
        return id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
