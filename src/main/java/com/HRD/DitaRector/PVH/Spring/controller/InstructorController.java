package com.HRD.DitaRector.PVH.Spring.controller;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Instructor;
import com.HRD.DitaRector.PVH.Spring.model.Request.InstructorRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
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
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructor(@RequestParam Integer page , @RequestParam Integer size ){
        ApiResponse<List<Instructor>> response = instructorService.getAllInstructor(page, size);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(summary = "Get instructor by ID")
    @GetMapping("{instructor-id}")
    public ResponseEntity<ApiResponse<List<Instructor>>> getInstructorById(@PathVariable("instructor-id") Long instructorId){
        ApiResponse<List<Instructor>> response = instructorService.getInstructorById(instructorId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(summary = "Delete Instructor By ID ")
    @DeleteMapping("{instructor-id}")
    public ResponseEntity<ApiResponse<Void>> deleteInstructorById(@PathVariable("instructor-id") Long instructorId ){
        ApiResponse<Void> response = instructorService.deleteUserById(instructorId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(summary = "Create Instructor By ID ")
    @PostMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> createInstructor(@RequestBody InstructorRequest instructorRequest) {
        ApiResponse<List<Instructor>> response = instructorService.createInstructor(instructorRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(summary = "Update Instructor By ID ")
    @PutMapping("{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable("instructor-id") Long instructorId , @RequestBody InstructorRequest instructorRequest ){
        ApiResponse<Instructor> response = instructorService.updateInstructor(instructorId, instructorRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
