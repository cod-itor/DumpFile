package com.HRD.DitaRector.PVH.Spring.service.impl;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Instructor;
import com.HRD.DitaRector.PVH.Spring.model.Request.InstructorRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import com.HRD.DitaRector.PVH.Spring.repository.InstructorRepository;
import com.HRD.DitaRector.PVH.Spring.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

//To Do List : Implement the Message like teacher make sure all of the method look great and acceptable
//Some of them give weird Response PLease Check it

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    public InstructorServiceImpl(InstructorRepository instructorRepository){
        this.instructorRepository = instructorRepository;
    }
    @Override
    public ApiResponse<List<Instructor>> getAllInstructor(Integer page, Integer size) {
        Integer offset = size * (page - 1);

        List<Instructor> instructors = instructorRepository.getAllInstructor(offset, size);
        return ApiResponse.<List<Instructor>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .messages("Instructor fetched successfully")
                .payload(instructors)
                .timestamp(Instant.now())
                .build();
    }
    @Override
    public ApiResponse<List<Instructor>> getInstructorById(Long instructorId){
        List<Instructor> instructors = instructorRepository.getInstructorById(instructorId);
        if (instructors != null){
            return ApiResponse.<List<Instructor>>builder()
                    .success(true)
                    .status(HttpStatus.OK.value())
                    .messages("Instructor fetched successfully")
                    .payload(instructors)
                    .timestamp(Instant.now())
                    .build();
        }else {
            return ApiResponse.<List<Instructor>>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND.value())
                    .messages("No instructor found with the given ID")
                    .timestamp(Instant.now())
                    .build();
        }
    }

    @Override
    public ApiResponse<Void> deleteUserById(Long instructorId) {
        instructorRepository.deleteUserById(instructorId);
        return ApiResponse.<Void>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .messages("Instructor deleted successfully")
                .timestamp(Instant.now())
                .build();
    }

    @Override
    public ApiResponse<List<Instructor>> createInstructor(InstructorRequest instructorRequest) {
        List<Instructor> instructors = instructorRepository.createInstructor(instructorRequest);
        if (instructors != null && !instructors.isEmpty()){
            return ApiResponse.<List<Instructor>>builder()
                    .success(true)
                    .status(HttpStatus.CREATED.value())
                    .messages("Instructor created successfully")
                    .payload(instructors)
                    .timestamp(Instant.now())
                    .build();
        }
        return ApiResponse.<List<Instructor>>builder()
                .success(false)
                .status(HttpStatus.BAD_REQUEST.value())
                .messages("Unable to create instructor")
                .timestamp(Instant.now())
                .build();
    }
    @Override
    public ApiResponse<Instructor> updateInstructor(Long instructorId, InstructorRequest instructorRequest){
        Instructor instructor = instructorRepository.updateInstructor(instructorId, instructorRequest);
        if (instructor != null){
            return ApiResponse.<Instructor>builder()
                    .success(true)
                    .status(HttpStatus.OK.value())
                    .messages("Instructor updated successfully")
                    .payload(instructor)
                    .timestamp(Instant.now())
                    .build();
        }else{
            return ApiResponse.<Instructor>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND.value())
                    .messages("Unable to find instructor for update")
                    .timestamp(Instant.now())
                    .build();
        }

    }

}
