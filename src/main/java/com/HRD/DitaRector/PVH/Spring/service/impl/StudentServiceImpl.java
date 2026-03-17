package com.HRD.DitaRector.PVH.Spring.service.impl;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.StudentsRequest;
import com.HRD.DitaRector.PVH.Spring.repository.StudentRepository;
import com.HRD.DitaRector.PVH.Spring.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getAllStudent(Integer page , Integer size){
        Integer offset = size*(page-1);
        return studentRepository.getAllStudent(offset, size);
    }
    @Override
    public Student getStudentById(Long studentId){
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Student createStudent(StudentsRequest studentsRequest) {

        return studentRepository.createStudent(studentsRequest);
    }
}
