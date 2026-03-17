package com.HRD.DitaRector.PVH.Spring.repository;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.StudentsRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {
@Results(id = "studentMapper",  value={
        @Result(property = "studentId", column = "student_id"),
        @Result(property = "studentName", column = "student_name"),
        @Result(property = "phoneNumber",column = "phone_number")
//        @Result(property = "courseList" , column = )
})

@Select("SELECT * FROM students OFFSET #{offset} LIMIT #{size}")
    List<Student> getAllStudent(Integer offset, Integer size);

@ResultMap("studentMapper")
@Select("SELECT * FROM students WHERE student_Id = #{studentId}")
    Student getStudentById(Long studentId);
@ResultMap("studentMapper")
@Select("""
INSERT INTO students VALUES (default,#{req.studentName}, #{req.email}
, #{req.phoneNumber}, #{req.courseId}) RETURNING* ;

""")
    Student createStudent(@Param("req")StudentsRequest studentsRequest);
}
