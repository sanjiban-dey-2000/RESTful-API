package com.sanjiban.restapi.service;

import com.sanjiban.restapi.dto.CreateStudentDto;
import com.sanjiban.restapi.dto.StudentDto;
import com.sanjiban.restapi.entities.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();

    StudentDto createStudent(CreateStudentDto createStudentDto);

    void deleteStudentById(String id);

    StudentDto updateStudent(String id, CreateStudentDto createStudentDto);

}
