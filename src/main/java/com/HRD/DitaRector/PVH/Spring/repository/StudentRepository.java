package com.HRD.DitaRector.PVH.Spring.repository;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.StudentsRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {
@Results(id = "studentMapper",  value={
        @Result(property = "")
})

@Select("SELECT * FROM students OFFSET #{offset} LIMIT #{size}")
    List<Student> getAllStudent(Integer offset, Integer size);


@Select("SELECT * FROM students WHERE studentId = #{studentId}")
    Student getStudentById(Long studentId);
@Select("""
INSERT INTO students VALUES (default,#{req.studentName}, #{req.email}
, #{req.phoneNumber}, #{req.courseId}) RETURNING* ;

""")
    Student createStudent(@Param("req")StudentsRequest studentsRequest);
}
