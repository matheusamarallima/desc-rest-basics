package com.matheus.students.controller;

import com.matheus.students.model.Student;
import com.matheus.students.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("students/{id}")
    private ResponseEntity<Student> searchStudentById(@PathVariable Long id){
        return studentService.searchStudentById(id);

    }

    @GetMapping("/students")
    private List<Student> searchAllStudent(){
        return studentService.searchAllStudent();
    }

    @PostMapping("/students")
    private ResponseEntity<Student> addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("students/{id}")
    private ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("students/{id}")
    private ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
