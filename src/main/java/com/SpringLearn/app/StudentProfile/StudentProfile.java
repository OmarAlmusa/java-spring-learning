package com.SpringLearn.app.StudentProfile;

import com.SpringLearn.app.Student.Student;
import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer id;
    private String bio;

    @OneToOne
    @JoinColumn(
            name="student_id"
    )
    private Student student;

    public StudentProfile() {
    }

    public StudentProfile(
            String bio,
            Student student
    ) {
        this.bio = bio;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public String getBio() {
        return bio;
    }

    public Student getStudent() {
        return student;
    }
}
