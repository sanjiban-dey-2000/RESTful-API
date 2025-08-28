package com.sanjiban.restapi.service.Impl;

import com.sanjiban.restapi.dto.CreateStudentDto;
import com.sanjiban.restapi.dto.StudentDto;
import com.sanjiban.restapi.entities.Student;
import com.sanjiban.restapi.respository.StudentRepository;
import com.sanjiban.restapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getStudents(){
        List<Student> students=studentRepository.findAll();
        List<StudentDto> studentDtoList=students.stream().map(student ->new StudentDto(student.getId(),student.getName(),student.getEmail(),student.getCourse())).toList();

        return studentDtoList;
    }

    @Override
    public StudentDto createStudent(CreateStudentDto createStudentDto){
        Student student=modelMapper.map(createStudentDto,Student.class);
        Student newStudent=studentRepository.save(student);
        StudentDto newStudentDto=modelMapper.map(newStudent,StudentDto.class);

        return newStudentDto;

    }

    @Override
    public void deleteStudentById(String id){
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found with id: "+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(String id, CreateStudentDto createStudentDto){
        Student student=studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id "+id));
        modelMapper.map(createStudentDto,student);
        student=studentRepository.save(student);

        return modelMapper.map(student,StudentDto.class);
    }


}
