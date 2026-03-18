package com.HRD.DitaRector.PVH.Spring.controller;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.StudentsRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import com.HRD.DitaRector.PVH.Spring.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.catalina.User;
import org.apache.coyote.Response;
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
        ApiResponse<List<Student>> response = studentService.getAllStudent(page, size);
        return ResponseEntity.ok(response);

    }
    @Operation(summary = "Get student by ID")
    @GetMapping("{student-id}")
    public ResponseEntity<ApiResponse<Student>> getStudentByIdById(@PathVariable("student-id") Long studentId){
        ApiResponse<Student> response = studentService.getStudentById(studentId);

        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Create a new Student")
    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody StudentsRequest studentsRequest){
        Student newStudent = studentService.createStudent(studentsRequest);
        if(newStudent != null){
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .success(true)
                    .status(200)
                    .messages("Students fetched successfully")
                    .payload(newStudent)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else {
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .success(false)
                    .status(400)
                    .messages("No students found with the given ID")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        }



    }




}
