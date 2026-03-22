package com.HRD.DitaRector.PVH.Spring.model.Request;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(example = "example@gmail.com")
    private String email;
    private String phoneNumber;
    private List<Integer> courseIds;
}