package com.example.student.manager.repo;

import com.example.student.manager.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface studentRepo extends JpaRepository<Student,Long> //class and its primary key
{
    //another methods that spring knows by convension
     void deleteStudentById(Long id);

    // option means may not return a student

    Optional<Student> findStudentById(Long id);



}
