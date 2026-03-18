package com.HRD.DitaRector.PVH.Spring.service;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Instructor;
import com.HRD.DitaRector.PVH.Spring.model.Request.InstructorRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;

import java.util.List;


public interface InstructorService {

    ApiResponse<List<Instructor>> getAllInstructor(Integer page , Integer size);
    ApiResponse<List<Instructor>> getInstructorById(Long instructorId);

    ApiResponse<Void> deleteUserById(Long instructorId);

    ApiResponse<List<Instructor>> createInstructor(InstructorRequest instructorRequest);

    ApiResponse<Instructor> updateInstructor(Long instructorId, InstructorRequest instructorRequest);
}
