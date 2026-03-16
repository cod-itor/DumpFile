package com.HRD.DitaRector.PVH.Spring.service;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getAllStudent(Integer page, Integer size);
}
