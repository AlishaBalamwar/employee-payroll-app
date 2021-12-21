package com.bridgelabz.employeepayrollapp.exception;

import com.bridgelabz.employeepayrollapp.dto.ErrorDetailDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Purpose: This class is created to handle custom global exception handler
 *
 * @author: ALISHA BALAMWAR
 * @since: 2021-12-13
 */
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Purpose : This method is created to handle the global exception which can occur while running the application
     *
     * @param ex:      This parameter is the reference for exception
     * @param headers: This is reference for http header
     * @param status:  This is reference http status
     * @param request: This is reference for Web request
     * @return: the new response entity which will holds the response DTO
     * that consist the exception message and Http status
     */
    @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("errors", errors);
        return new ResponseEntity<>(body, headers, status);
    }

    /**
     * Purpose: This method is used to handle resource not found exception
     *
     * @param exception: this is reference for resource not found exception
     * @param request:   this is reference for web request
     * @return: response entity
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        ErrorDetailDto errorDetailDto = new ErrorDetailDto(new Date(), exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(errorDetailDto, HttpStatus.NOT_FOUND);
    }

}
