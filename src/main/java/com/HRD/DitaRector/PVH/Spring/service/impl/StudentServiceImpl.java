package com.HRD.DitaRector.PVH.Spring.service.impl;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.StudentsRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import com.HRD.DitaRector.PVH.Spring.repository.StudentRepository;
import com.HRD.DitaRector.PVH.Spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
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
                    .status(HttpStatus.OK.value())
                    .messages("Students fetched successfully")
                    .payload(students)
                    .timestamp(Instant.now())
                    .build();
        }else{
            return ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND.value())
                    .messages("No students found with the given ID")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
        }
    }

    @Override
    public ApiResponse<List<Student>> createStudent(StudentsRequest studentsRequest) {
        List<Student> students = studentRepository.createStudent(studentsRequest);
        if(students != null){
            return  ApiResponse.<List<Student>>builder()
                    .success(true)
                    .status(HttpStatus.CREATED.value())
                    .messages("Students fetched successfully")
                    .payload(students)
                    .timestamp(Instant.now())
                    .build();
        }else{
            return ApiResponse.<List<Student>>builder()
                    .success(false)
                    .status(HttpStatus.BAD_REQUEST.value())
                    .messages("No students found with the given ID")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
        }
    }
    @Override
    public ApiResponse<Void> deleteStudentById(Long studentId){
        int junctionRowDeleted = studentRepository.deleteStudentRelated(studentId);
        int rowDeleted = studentRepository.deleteStudentById(studentId);
        if(rowDeleted > 0 &  junctionRowDeleted > 0 ){
            return ApiResponse.<Void>builder()
                    .success(true)
                    .status(HttpStatus.OK.value())
                    .messages("Student deleted successfully")
                    .timestamp(Instant.now())
                    .build();
        }
            return ApiResponse.<Void>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND.value())
                    .messages("No students found with the given ID")
                    .timestamp(Instant.now())
                    .build();

        }

}

