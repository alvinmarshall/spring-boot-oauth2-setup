package com.cheise_proj.orderservice.config;


import com.cheise_proj.orderservice.dto.APIError;
import com.cheise_proj.orderservice.dto.APIResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalControllerAdvice {

    private final MessageSource messageSource;

    public GlobalControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIResponseData<?>> RuntimeException(RuntimeException runtimeException) {
        log.error("Entity not found exception", runtimeException);
        List<APIError> errors = new ArrayList<>();
        errors.add(APIError.builder()
                .errorDetails(runtimeException.getMessage())
                .build());

        APIResponseData<?> apiResponse = APIResponseData.builder()
                .success(false)
                .errors(errors)
                .build();

        return new ResponseEntity<>(apiResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponseData<?>> otherException(Exception runtimeException) {
        log.error("Other not found exception", runtimeException);
        List<APIError> errors = new ArrayList<>();
        errors.add(APIError.builder()
                .errorDetails(runtimeException.getMessage())
                .build());

        APIResponseData<?> apiResponse = APIResponseData.builder()
                .success(false)
                .errors(errors)
                .build();

        return new ResponseEntity<>(apiResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
