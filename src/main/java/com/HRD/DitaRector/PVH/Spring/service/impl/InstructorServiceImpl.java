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
                .status(200)
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
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
        }
    }

    @Override
    public void deleteUserById(Long instructorId) {
         instructorRepository.deleteUserById(instructorId);
    }

    @Override
    public List<Instructor> createInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.createInstructor(instructorRequest);
    }
    @Override
    public Instructor updateInstructor(Long instructorId, InstructorRequest instructorRequest){

        return instructorRepository.updateInstructor(instructorId, instructorRequest);
    }


}
