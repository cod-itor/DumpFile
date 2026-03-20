package com.HRD.DitaRector.PVH.Spring.repository;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Course;
import com.HRD.DitaRector.PVH.Spring.model.Request.CourseRequest;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Mapper
public interface CourseRepository {
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructorList", column = "instructor_id", one = @One(select = "com.HRD.DitaRector.PVH.Spring.repository.InstructorRepository.getInstructorByIdSingle"))
    })
    @Select("SELECT * FROM courses OFFSET #{offset} LIMIT #{size}")
    List<Course> getAllCourse(Integer offset, Integer size);
@ResultMap("courseMapper")
@Select("SELECT * FROM courses WHERE course_id = #{courseId}")
    List<Course> getCourseById(Long courseId);




    @ResultMap("courseMapper")
    @Select("SELECT * FROM courses WHERE course_id IN (SELECT course_id FROM student_course WHERE student_id = #{studentId})")
    List<Course> getCoursesByStudentId(Long studentId);
@ResultMap("courseMapper")
@Select("INSERT INTO courses VALUES (default,#{req.courseName},#{req.description} ,#{req.instructorId}) RETURNING *" )
    List<Course> createCourse(@Param("req") CourseRequest courseRequest);

    @ResultMap("courseMapper")
    @Delete("DELETE FROM courses WHERE course_id = #{courseId}")
    Long deleteCourseById(Long courseId);
    @ResultMap("courseMapper")
    @Select("""
        UPDATE courses 
        SET course_name = #{req.courseName}, 
            description = #{req.description}, 
            instructor_id = #{req.instructorId} 
        WHERE course_id = #{courseId} 
        RETURNING *
    """)
    List<Course> updateCourseById( Long courseId , @Param("req")CourseRequest courseRequest);
}

