package com.HRD.DitaRector.PVH.Spring.service;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.StudentsRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    ApiResponse<List<Student>> getAllStudent(Integer page, Integer size);
    ApiResponse<Student> getStudentById(Long studentId);

    ApiResponse<List<Student>> createStudent(StudentsRequest studentsRequest);

    ApiResponse<Void> deleteStudentById(Long studentId);
}
