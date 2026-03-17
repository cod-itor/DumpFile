package com.HRD.DitaRector.PVH.Spring.repository;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Instructor;
import org.apache.ibatis.annotations.*;

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
}
