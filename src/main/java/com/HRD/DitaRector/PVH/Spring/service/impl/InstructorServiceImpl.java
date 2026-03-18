package com.HRD.DitaRector.PVH.Spring.service.impl;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Instructor;
import com.HRD.DitaRector.PVH.Spring.model.Request.InstructorRequest;
import com.HRD.DitaRector.PVH.Spring.repository.InstructorRepository;
import com.HRD.DitaRector.PVH.Spring.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository){
        this.instructorRepository = instructorRepository;
    }
    @Override
    public List<Instructor> getAllInstructor(Integer page , Integer size ){
        Integer offset = size *(page -1 );
        return instructorRepository.getAllInstructor(offset ,size);
    }
    @Override
    public Instructor getInstructorById(Long instructorId){
        return instructorRepository.getInstructorById(instructorId);
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
