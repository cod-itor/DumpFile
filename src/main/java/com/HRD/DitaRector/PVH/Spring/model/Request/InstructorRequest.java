package com.HRD.DitaRector.PVH.Spring.model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
    private String instructorName;
    private String email;
}
