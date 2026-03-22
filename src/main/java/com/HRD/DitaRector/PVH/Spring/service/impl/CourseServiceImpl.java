package com.HRD.DitaRector.PVH.Spring.service.impl;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Course;
import com.HRD.DitaRector.PVH.Spring.model.Request.CourseRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import com.HRD.DitaRector.PVH.Spring.repository.CourseRepository;
import com.HRD.DitaRector.PVH.Spring.repository.InstructorRepository;
import com.HRD.DitaRector.PVH.Spring.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;


    public CourseServiceImpl(CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public ApiResponse<List<Course>> getAllCourse(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        Integer offset = size * (page - 1);
        List<Course> response = courseRepository.getAllCourse(offset, size);
        return ApiResponse.<List<Course>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .messages("Course fetched successfully")
                .payload(response)
                .timestamp(Instant.now())
                .build();
    }

    @Override
    public ApiResponse<Course> getCourseById(Long courseId) {
        Course course = courseRepository.getCourseById(courseId);
        if (course != null) {
            return ApiResponse.<Course>builder()
                    .success(true)
                    .status(HttpStatus.OK.value())
                    .messages("Course fetched successfully")
                    .payload(course)
                    .timestamp(Instant.now())
                    .build();

        }
        return ApiResponse.<Course>builder()
                .success(false)
                .status(HttpStatus.NOT_FOUND.value())
                .messages("No instructor found with the given ID")
                .timestamp(Instant.now())
                .build();
    }

    @Override
    public ApiResponse<List<Course>> createCourse(CourseRequest courseRequest) {
        Long instructorId = courseRequest.getInstructorId();
        if (instructorId == null || !instructorRepository.instructorExists(instructorId)) {
            return ApiResponse.<List<Course>>builder()
                    .success(false)
                    .status(HttpStatus.BAD_REQUEST.value())
                    .messages("Invalid instructorId: " + instructorId)
                    .timestamp(Instant.now())
                    .build();
        }

        List<Course> course = courseRepository.createCourse(courseRequest);
        if (course == null || course.isEmpty()) {
            return ApiResponse.<List<Course>>builder()
                    .success(false)
                    .status(HttpStatus.BAD_REQUEST.value())
                    .messages("Unable to create Course")
                    .timestamp(Instant.now())
                    .build();
        }

        return ApiResponse.<List<Course>>builder()
                .success(true)
                .status(HttpStatus.CREATED.value())
                .messages("Course created successfully")
                .payload(course)
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
        Long instructorId = courseRequest.getInstructorId();
        if (instructorId == null || !instructorRepository.instructorExists(instructorId)) {
            return ApiResponse.<List<Course>>builder()
                    .success(false)
                    .status(HttpStatus.BAD_REQUEST.value())
                    .messages("No instructor found with the given ID  " )
                    .timestamp(Instant.now())
                    .build();
        }

        List<Course> response = courseRepository.updateCourseById(courseId, courseRequest);
        if (response == null || response.isEmpty()) {
            return ApiResponse.<List<Course>>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND.value())
                    .messages("No courses found with the given ID")
                    .timestamp(Instant.now())
                    .build();
        }
        return ApiResponse.<List<Course>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .messages("Course updated successfully")
                .payload(response)
                .timestamp(Instant.now())
                .build();


    }
}
