package br.com.condominus.Condominus.exceptions.exceptionModel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponse {

    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
