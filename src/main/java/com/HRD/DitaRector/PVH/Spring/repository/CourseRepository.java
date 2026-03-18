package com.HRD.DitaRector.PVH.Spring.repository;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Course;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CourseRepository {
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId" , column = "course_id"),
            @Result(property = "courseName" , column = "course_name"),
            @Result(property = "instructionList " ,column = "course_id",one =  @One(select = "com.HRD.DitaRector.PVH.Spring.service.impl.InstructorServiceImpl.getInstructorById")),
    })
    @Select(
    "SELECT *  FROM courses OFFSET #{offset} LIMIT #{size}")
    List<Course> getAllCourse(Integer offset, Integer size);
@ResultMap("courseMapper")
@Select("SELECT * FROM courses WHERE course_id = #{courseId}")
    Course getCourseByID(Long courseId);
}
