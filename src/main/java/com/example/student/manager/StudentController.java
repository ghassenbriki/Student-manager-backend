package com.example.student.manager;


import com.example.student.manager.models.Student;
import com.example.student.manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController
{
    private final  StudentService stdService;
    @Autowired
    public  StudentController(StudentService stdService)
    {
        this.stdService=stdService;
    }


@GetMapping("/all")
public ResponseEntity<List<Student>> getAllStudents()  /*return a response that contains List<Student>*/
{
    List<Student> students= this.stdService.getAllStudent();
    return new ResponseEntity<>(students, HttpStatus.OK);
}

@GetMapping("/find/{id}")

public ResponseEntity<Student> getStudentByID (@PathVariable ("id") Long id)
{
    Student std=stdService.findStudentById(id);
    return new ResponseEntity<>(std, HttpStatus.OK);
}

@PostMapping("/add")

public ResponseEntity<Student> addStudent(@RequestBody Student std)
{
    Student newStd=this.stdService.addStudent(std);
    return new ResponseEntity<>(newStd,HttpStatus.CREATED);
}

@PutMapping("/update")

ResponseEntity<Student> UpdateStudent(@RequestBody Student std)
{
    Student updatedStd=this.stdService.updateStudent(std);
    return new ResponseEntity<>(updatedStd,HttpStatus.OK);
}

@DeleteMapping("/delete/{id}")

public ResponseEntity<?> deleteStudent (@PathVariable ("id") Long id)
{
    stdService.deleteStudent(id);
    return new ResponseEntity<>(HttpStatus.OK);
}



}
