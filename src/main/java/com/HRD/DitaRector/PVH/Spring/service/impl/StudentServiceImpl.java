package com.HRD.DitaRector.PVH.Spring.service.impl;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentService studentService;

    public StudentServiceImpl(StudentService studentService){
        this.studentService = studentService;

    }


    @Override
    public List<Student> getAllStudent(Integer page , Integer size){
        Integer offset = size*(page-1);
        return studentService.getAllStudent(offset, size);
    }
 }
