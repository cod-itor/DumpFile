package com.HRD.DitaRector.PVH.Spring.model.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
    private String instructorName;
    @Schema(example = "example@gmail.com")
    private String email;
}
