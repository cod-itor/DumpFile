package com.HRD.DitaRector.PVH.Spring.controller;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Instructor;
import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.InstructorRequest;
import com.HRD.DitaRector.PVH.Spring.model.Response.ApiResponse;
import com.HRD.DitaRector.PVH.Spring.service.InstructorService;
import io.swagger.v3.core.util.OpenAPI30To31;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
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
    public ResponseEntity< ApiResponse<List<Instructor>>> getAllInstructor(@RequestParam Integer page , @RequestParam Integer size ){
        ApiResponse<List<Instructor>> response = instructorService.getAllInstructor(page, size);
        return ResponseEntity.ok(response);

    }
    @Operation(summary = "Get instructor by ID")
    @GetMapping("{instructor-id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable("instructor-id") Long instructorId){

        return ResponseEntity.ok(instructorService.getInstructorById(instructorId));
    }
    @Operation(summary = "Delete Instructor By ID ")
    @DeleteMapping("{instructor-id}")
    public void deleteInstructorById(@PathVariable("instructor-id") Long instructorId ){
        instructorService.deleteUserById(instructorId);

    }
    @Operation(summary = "Create Instructor By ID ")
    @PostMapping
    public ResponseEntity<List<Instructor>> createInstructor(@RequestBody InstructorRequest instructorRequest) {

        return ResponseEntity.ok(instructorService.createInstructor(instructorRequest));
        }
    @Operation(summary = "Update Instructor By ID ")
    @PutMapping("{instructor-id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable("instructor-id") Long instructorId , @RequestBody InstructorRequest instructorRequest ){

        return ResponseEntity.ok(instructorService.updateInstructor(instructorId ,instructorRequest));
    }


}
