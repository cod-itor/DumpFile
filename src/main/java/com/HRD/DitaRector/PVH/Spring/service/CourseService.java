package com.HRD.DitaRector.PVH.Spring.service;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Course;
import com.HRD.DitaRector.PVH.Spring.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {


    List<Course> getAllCourse(Integer page , Integer size);

    List<Course> getCourseById(Long courseId);
}
