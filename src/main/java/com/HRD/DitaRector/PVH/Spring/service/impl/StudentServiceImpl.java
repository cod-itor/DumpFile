package com.HRD.DitaRector.PVH.Spring.service.impl;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.StudentsRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import com.HRD.DitaRector.PVH.Spring.repository.CourseRepository;
import com.HRD.DitaRector.PVH.Spring.repository.StudentRepository;
import com.HRD.DitaRector.PVH.Spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public ApiResponse<List<Student>> getAllStudent(Integer page, Integer size) {
        Integer offset = size * (page - 1);
        List<Student> students = studentRepository.getAllStudent(offset, size);
        return ApiResponse.<List<Student>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .messages("Students retrieved successfully")
                .payload(students)
                .timestamp(Instant.now())
                .build();
    }

    @Override
    public ApiResponse<Student> getStudentById(Long studentId) {
        Student student = studentRepository.getStudentById(studentId);

        if (student != null) {
            return ApiResponse.<Student>builder()
                    .success(true)
                    .status(HttpStatus.OK.value())
                    .messages("Student fetched successfully")
                    .payload(student)
                    .timestamp(Instant.now())
                    .build();
        }
        return ApiResponse.<Student>builder()
                .success(false)
                .status(HttpStatus.NOT_FOUND.value())
                .messages("No student found with the given ID")
                .timestamp(Instant.now())
                .build();
    }

    @Override
    public ApiResponse<Student> createStudent(StudentsRequest studentsRequest) {
        if (studentRepository.emailExists(studentsRequest.getEmail())) {
            return ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.CONFLICT.value())
                    .messages("Email already exists")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
        }

        List<Integer> courseIds = studentsRequest.getCourseIds();
        if (courseIds != null && !courseIds.isEmpty()) {
            List<Integer> invalidCourseIds = new ArrayList<>();
            for (Integer courseId : courseIds) {
                if (courseId == null || !courseRepository.courseExists(Long.valueOf(courseId))) {
                    invalidCourseIds.add(courseId);
                }
            }

            if (!invalidCourseIds.isEmpty()) {
                return ApiResponse.<Student>builder()
                        .success(false)
                        .status(HttpStatus.BAD_REQUEST.value())
                        .messages("Invalid course IDs: " + invalidCourseIds)
                        .payload(null)
                        .timestamp(Instant.now())
                        .build();
            }
        }

        Long newStudentId = studentRepository.insertStudent(studentsRequest);

        if (newStudentId == null) {
            return ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.BAD_REQUEST.value())
                    .messages("Failed to create student")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
        }

        if (courseIds != null && !courseIds.isEmpty()) {
            for (Integer courseId : courseIds) {
                studentRepository.insertStudentCourse(newStudentId, courseId);
            }
        }

        Student created = studentRepository.getStudentWithCoursesById(newStudentId);

        return ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.CREATED.value())
                .messages("Student created successfully")
                .payload(created)
                .timestamp(Instant.now())
                .build();
    }

    @Override
    public ApiResponse<Student> updateStudentById(Long studentId, StudentsRequest studentsRequest) {
        int rows = studentRepository.updateStudentById(studentId, studentsRequest);

        if (rows == 0) {
            return ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND.value())
                    .messages("No student found with the given ID")
                    .timestamp(Instant.now())
                    .build();
        }

        if (studentsRequest.getCourseIds() != null && !studentsRequest.getCourseIds().isEmpty()) {
            studentRepository.deleteStudentRelated(studentId);
            for (Integer courseId : studentsRequest.getCourseIds()) {
                studentRepository.insertStudentCourse(studentId, courseId);
            }
        }

        Student updated = studentRepository.getStudentWithCoursesById(studentId);
        return ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .messages("Student updated successfully")
                .payload(updated)
                .timestamp(Instant.now())
                .build();
    }

    @Override
    public ApiResponse<Void> deleteStudentById(Long studentId) {
        studentRepository.deleteStudentRelated(studentId);
        int rowsDeleted = studentRepository.deleteStudentById(studentId);

        if (rowsDeleted > 0) {
            return ApiResponse.<Void>builder()
                    .success(true)
                    .status(HttpStatus.OK.value())
                    .messages("Student deleted successfully")
                    .timestamp(Instant.now())
                    .build();
        }
        return ApiResponse.<Void>builder()
                .success(false)
                .status(HttpStatus.NOT_FOUND.value())
                .messages("No student found with the given ID")
                .timestamp(Instant.now())
                .build();
    }
}