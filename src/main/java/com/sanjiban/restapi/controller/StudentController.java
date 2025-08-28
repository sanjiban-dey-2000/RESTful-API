package com.sanjiban.restapi.controller;

import com.sanjiban.restapi.dto.CreateStudentDto;
import com.sanjiban.restapi.dto.StudentDto;
import com.sanjiban.restapi.service.Impl.StudentServiceImpl;
import com.sanjiban.restapi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }

    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody CreateStudentDto createStudentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(createStudentDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable String id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable String id, @RequestBody CreateStudentDto createStudentDto){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(id,createStudentDto));
    }
}
