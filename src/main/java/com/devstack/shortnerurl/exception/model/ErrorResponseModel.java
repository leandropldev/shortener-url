package com.devstack.shortnerurl.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponseModel {
    private String message;
    private int status;
    private LocalDateTime timestamp;
}
