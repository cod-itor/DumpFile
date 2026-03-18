package com.HRD.DitaRector.PVH.Spring.repository;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Instructor;
import com.HRD.DitaRector.PVH.Spring.model.Request.InstructorRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Mapper
public interface InstructorRepository {

    @Results(id = "instructorMapper" , value = {
            @Result(property = "instructorId" , column = "instructor_id"),
            @Result(property = "instructorName" , column = "instructor_name")
    })

    @Select("SELECT * FROM instructors OFFSET #{offset} LIMIT #{size}")
    List<Instructor> getAllInstructor(Integer offset , Integer size);
@ResultMap("instructorMapper")
    @Select("SELECT * FROM instructors WHERE instructor_id = #{instructorId}")
    Instructor getInstructorById(Long instructorId);


    @Delete("DELETE FROM instructors WHERE instructor_id = #{instructorId}")
    void deleteUserById(Long instructorId);
@Select("INSERT INTO instructors VALUES (default,#{req.instructorName}, #{req.email} ) RETURNING *")
    List<Instructor> createInstructor(@Param("req") InstructorRequest instructorRequest);
@Select("UPDATE instructors SET instructor_name = #{req.instructorName} , email = #{req.email} WHERE instructor_id = #{instructorId} ;")
    Instructor updateInstructor( Long instructorId,@Param("req") InstructorRequest instructorRequest);
}

