package com.HRD.DitaRector.PVH.Spring.service;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Instructor;
import com.HRD.DitaRector.PVH.Spring.model.Request.InstructorRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InstructorService {

List<Instructor> getAllInstructor(Integer page , Integer size);
Instructor getInstructorById(Long instructorId);

    void deleteUserById(Long instructorId);

    List<Instructor> createInstructor(InstructorRequest instructorRequest);

    Instructor updateInstructor(Long instructorId, InstructorRequest instructorRequest);
}
