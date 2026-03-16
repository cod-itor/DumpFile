package com.HRD.DitaRector.PVH.Spring.model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentsRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Long> courseId;
}
