package com.HRD.DitaRector.PVH.Spring.repository;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentRepository {


@Select("SELECT * FROM students OFFSET #{offset} LIMIT #{size}")
    List<Student> getAllStudent(Integer offset, Integer size);
}
