package com.HRD.DitaRector.PVH.Spring.model.Request;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String courseName;
    private String description;
    private Instructor instructorList;
}
