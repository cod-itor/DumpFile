package com.HRD.DitaRector.PVH.Spring.service;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Course;
import com.HRD.DitaRector.PVH.Spring.model.Request.CourseRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;


import java.util.List;

public interface CourseService {


    List<Course> getAllCourse(Integer page , Integer size);

    List<Course> getCourseById(Long courseId);

    ApiResponse<List<Course>> createCourse(CourseRequest courseRequest);

    ApiResponse<Void> deleteCourseById(Long courseId);

    ApiResponse<List<Course>> updateCourseById(Long courseId, CourseRequest courseRequest);
}
