package com.HRD.DitaRector.PVH.Spring.controller;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Instructor;
import com.HRD.DitaRector.PVH.Spring.service.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService){
        this.instructorService = instructorService;
    }

    @Operation(summary = "Get All instructors")
    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructor(@RequestParam Integer page , @RequestParam Integer size ){
        return ResponseEntity.ok(instructorService.getAllInstructor(page, size));

    }
    @Operation(summary = "Get instructor by ID")
    @GetMapping("{instructor-id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable("instructor-id") Long instructorId){
        return ResponseEntity.ok(instructorService.getInstructorById(instructorId));
    }



}
