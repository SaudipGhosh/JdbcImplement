package com.SpringDataJdbc.JdbcImplement.Advice;

import com.SpringDataJdbc.JdbcImplement.Exception.EmptyInputException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> emptyInput(EmptyInputException emptyInputException){
        return new ResponseEntity<String>("Name field is empty,please look into it", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchFieldException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchFieldException noSuchFieldException){
        return new ResponseEntity<String>("no value present in DB,Please chance ypur Request",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException){
        return new ResponseEntity<String>("no input is given,please insert a value",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleIllegalArgumentException(EmptyResultDataAccessException emptyResultDataAccessException){
        return new ResponseEntity<String>("no data in DB for your input,please give a valid input",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException nullPointerException){
        return new ResponseEntity<String>("input field is empty ,please input data in all the fields",HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception exception) {
//        exception.printStackTrace();
//        return new ResponseEntity<String>("An error occurred: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<Object>("please change your Http method type",HttpStatus.BAD_REQUEST);
    }
}
