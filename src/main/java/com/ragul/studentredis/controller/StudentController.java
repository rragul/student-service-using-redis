package com.ragul.studentredis.controller;

import com.ragul.studentredis.entity.Student;
import com.ragul.studentredis.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student/")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getStudents(){
        return service.getStudents();
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable int id){
        return service.getStudentById(id);
    }

    @DeleteMapping("{id}")
    public String removeStudent(@PathVariable int id){
        return service.removeStudent(id);
    }

}
