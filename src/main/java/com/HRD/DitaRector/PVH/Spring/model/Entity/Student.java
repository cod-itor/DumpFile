package com.HRD.DitaRector.PVH.Spring.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long studentId;
    private String studentName;
    private String email;
    private String phoneNumber;

}
