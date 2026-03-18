package com.HRD.DitaRector.PVH.Spring.service.impl;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.StudentsRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import com.HRD.DitaRector.PVH.Spring.repository.StudentRepository;
import com.HRD.DitaRector.PVH.Spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public ApiResponse<List<Student>> getAllStudent(Integer page , Integer size){
        Integer offset = size*(page-1);
        List<Student> students = studentRepository.getAllStudent(offset , size);
        return ApiResponse.<List<Student>>builder()
                .success(true)
                .status(200)
                .messages("Students retrieved successfully")
                .payload(students)
                .timestamp(Instant.now())
                .build();
    }
    @Override
    public ApiResponse<Student> getStudentById(Long studentId){
       Student students = studentRepository.getStudentById(studentId);
        if(students != null){
           return  ApiResponse.<Student>builder()
                    .success(true)
                    .status(200)
                    .messages("Students fetched successfully")
                    .payload(students)
                    .timestamp(Instant.now())
                    .build();
        }else{
            return ApiResponse.<Student>builder()
                    .success(true)
                    .status(200)
                    .messages("No students found with the given ID")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
        }
    }

    @Override
    public Student createStudent(StudentsRequest studentsRequest) {

        return studentRepository.createStudent(studentsRequest);
    }
}
