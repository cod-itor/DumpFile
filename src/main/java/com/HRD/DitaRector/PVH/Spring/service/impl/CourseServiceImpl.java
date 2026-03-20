package com.HRD.DitaRector.PVH.Spring.service.impl;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Course;
import com.HRD.DitaRector.PVH.Spring.model.Entity.Instructor;
import com.HRD.DitaRector.PVH.Spring.model.Request.CourseRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import com.HRD.DitaRector.PVH.Spring.repository.CourseRepository;
import com.HRD.DitaRector.PVH.Spring.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
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
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public ApiResponse<List<Course>> createCourse(CourseRequest courseRequest) {
        List<Course> course = courseRepository.createCourse(courseRequest);
        if (course != null && !course.isEmpty()){
            return ApiResponse.<List<Course>>builder()
                    .success(true)
                    .status(HttpStatus.CREATED.value())
                    .messages("Course created successfully")
                    .payload(course)
                    .timestamp(Instant.now())
                    .build();
        }
        return ApiResponse.<List<Course>>builder()
                .success(false)
                .status(HttpStatus.BAD_REQUEST.value())
                .messages("Unable to create Course")
                .timestamp(Instant.now())
                .build();
    }

    @Override
    public ApiResponse<Void> deleteCourseById(Long courseId) {
        Long rowsDeleted = courseRepository.deleteCourseById(courseId);
        if (rowsDeleted > 0) {
            return ApiResponse.<Void>builder()
                    .success(true)
                    .status(HttpStatus.OK.value())
                    .messages("Course deleted successfully")
                    .timestamp(Instant.now())
                    .build();
        }
        return ApiResponse.<Void>builder()
                .success(false)
                .status(HttpStatus.NOT_FOUND.value())
                .messages("No courses found with the given ID")
                .timestamp(Instant.now())
                .build();
    }

    @Override
    public ApiResponse<List<Course>> updateCourseById(Long courseId, CourseRequest courseRequest) {

        List<Course> response = courseRepository.updateCourseById(courseId, courseRequest);

        if(!response.isEmpty()){
            return ApiResponse.<List<Course>>builder()
                    .success(true)
                    .status(HttpStatus.OK.value())
                    .messages("Course updated successfully")
                    .payload(response)
                    .timestamp(Instant.now())
                    .build();
        }

        return ApiResponse.<List<Course>>builder()
                .success(false)
                .status(HttpStatus.NOT_FOUND.value())
                .messages("No courses found with the given ID")
                .timestamp(Instant.now())
                .build();
    }


}
