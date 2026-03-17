package com.HRD.DitaRector.PVH.Spring.service;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.StudentsRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent(Integer page, Integer size);
    Student getStudentById(Long studentId);

    Student createStudent(StudentsRequest studentsRequest);
}
