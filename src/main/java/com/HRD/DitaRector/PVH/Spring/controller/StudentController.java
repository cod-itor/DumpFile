package com.HRD.DitaRector.PVH.Spring.controller;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.StudentsRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import com.HRD.DitaRector.PVH.Spring.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;

import org.apache.coyote.Response;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @Operation(summary = "Get student by ID")
    @GetMapping("{student-id}")
    public ResponseEntity<ApiResponse<Student>> getStudentByIdById(@PathVariable("student-id") Long studentId){
        ApiResponse<Student> response = studentService.getStudentById(studentId);

        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @Operation(summary = "Create a new Student")
    @PostMapping
    public ResponseEntity<ApiResponse<List<Student>>> createStudent(@RequestBody StudentsRequest studentsRequest){
        ApiResponse<List<Student>> response = studentService.createStudent(studentsRequest);
            return ResponseEntity.status(response.getStatus()).body(response);


    }
    @Operation(summary = "Delete student by ID")
    @DeleteMapping("{student-id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudentById(@PathVariable("student-id") Long studentId){
        ApiResponse<Void> response = studentService.deleteStudentById(studentId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }



}
