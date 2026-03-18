package com.HRD.DitaRector.PVH.Spring.service.impl;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Course;
import com.HRD.DitaRector.PVH.Spring.repository.CourseRepository;
import com.HRD.DitaRector.PVH.Spring.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;


    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse(Integer page , Integer size){
        Integer offset = size *(page -1 );
        return courseRepository.getAllCourse(offset , size);
    }

    @Override
    public List<Course> getCourseById(Long courseId) {
        return courseRepository.getCourseByID(courseId);
    }


}
