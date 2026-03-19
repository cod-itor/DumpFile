package com.HRD.DitaRector.PVH.Spring.controller;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Course;
import com.HRD.DitaRector.PVH.Spring.model.Entity.Instructor;
import com.HRD.DitaRector.PVH.Spring.model.Request.CourseRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import com.HRD.DitaRector.PVH.Spring.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.Response;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Operation(summary = "Get All course")
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourse(@RequestParam @DefaultValue("10") Integer page, @RequestParam @DefaultValue("10") Integer size) {
        return ResponseEntity.ok(courseService.getAllCourse(page, size));

    }

    @Operation(summary = "Get Instructor By ID")
    @GetMapping("/{course_id}")
    public ResponseEntity<List<Course>> getUserById(@PathVariable("course_id") Long courseId) {
        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }
    @Operation(summary = "Post Instructor By Id")
    @PostMapping
    public ResponseEntity<ApiResponse<List<Course>>> createCourse(@RequestBody CourseRequest courseRequest){
        return ResponseEntity.ok(courseService.createCourse(courseRequest));

    }
}