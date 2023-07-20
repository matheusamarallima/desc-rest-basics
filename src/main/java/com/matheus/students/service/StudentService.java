package com.matheus.students.service;

import com.matheus.students.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private static Map<Long, Student> listStudents = new HashMap<>();

    public ResponseEntity<Student> searchStudentById(Long id){
        Student student = listStudents.get(id);
        if(student == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    public List<Student> searchAllStudent(){
        return new ArrayList<>(listStudents.values());
    }

    public ResponseEntity<Student> addStudent(Student student){
        Student studentFound = student;
        listStudents.put(studentFound.getId(), student);
        if(studentFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentFound);
    }

    public ResponseEntity<Student> updateStudent(Student student){
        Student studentFound = listStudents.get(student.getId());
        listStudents.put(studentFound.getId(), student);
        if(studentFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listStudents.put(student.getId(), student);
        return ResponseEntity.status(HttpStatus.OK).body(studentFound);
    }

    public ResponseEntity<String> deleteStudent(Long id){
        Student studentFound = listStudents.get(id);
        if(studentFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listStudents.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
    }
}


