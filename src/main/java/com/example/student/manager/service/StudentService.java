package com.example.student.manager.service;

import com.example.student.manager.models.Student;
import com.example.student.manager.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.example.student.manager.exceptions.*;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
private final studentRepo studentRepo;

@Autowired
public StudentService(studentRepo stdRepo)
{
      this.studentRepo=stdRepo;
}

public Student addStudent(Student std)
{

      return studentRepo.save(std);
}

public List<Student> getAllStudent()
{
     return studentRepo.findAll();
}

public Student updateStudent(Student std)
{
      return studentRepo.save((std));
}

public void deleteStudent(Long id)
{
      studentRepo.deleteStudentById(id);
}

public Student findStudentById(Long id)
{
    return studentRepo.findStudentById(id)
            .orElseThrow(()->new StudentNotFoundException("student by id "+id+" was not found"));
}

}
