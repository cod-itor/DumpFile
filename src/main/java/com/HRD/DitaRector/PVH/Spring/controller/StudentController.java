package com.HRD.DitaRector.PVH.Spring.controller;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.StudentsRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import com.HRD.DitaRector.PVH.Spring.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController

@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }

    @Operation(summary = "Get All students")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<Student> studentList = studentService.getAllStudent(page, size);
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .success(true)
                .status(HttpStatus.OK)
                .messages("Students retrieved successfully")
                .payload(studentList)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get student by ID")
    @GetMapping("{student-id}")
    public ResponseEntity<ApiResponse<Student>> getStudentByIdById(@PathVariable("student-id") Long studentId){
        Student studentById = studentService.getStudentById(studentId);
        if(studentById != null){
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .messages("Students fetched successfully")
                    .payload(studentById)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else {
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .messages("No students found with the given ID")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        }
    }
    @Operation(summary = "Create a new Student")
    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody StudentsRequest studentsRequest){
        Student newStudent = studentService.createStudent(studentsRequest);
        if(newStudent != null){
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .messages("Students fetched successfully")
                    .payload(newStudent)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else {
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .messages("No students found with the given ID")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        }



    }




}
