package com.HRD.DitaRector.PVH.Spring.model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentsRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Integer> courseIds;
}