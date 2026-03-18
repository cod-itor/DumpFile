package com.HRD.DitaRector.PVH.Spring.model.Response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.Instant;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private Integer status;
    private String messages;
    private T payload;
    private Instant timestamp;

}
