package com.example.exercisejparelationil.ControllerAdvice;

import com.example.exercisejparelationil.ApiResponse.ApiException;
import com.example.exercisejparelationil.ApiResponse.ApiResponse;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ControllerAdvise{




    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse> ApiException(ApiException e){

        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
    }

    @ExceptionHandler(value = DuplicateKeyException.class)
    public ResponseEntity<ApiResponse> ApiException(DuplicateKeyException e){
        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
    }
}
