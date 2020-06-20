package com.user.exception;

import org.omg.CORBA.DynAnyPackage.Invalid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger= LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ResponseError> handleNotFoundException(UserNotFoundException e) {
        return error(new ResponseError(HttpStatus.NOT_FOUND ,e.getMessage()));
    }

    @ExceptionHandler({InvalidInputException.class})
    public ResponseEntity<ResponseError> handleInvalidInputException(InvalidInputException e) {
        return error(new ResponseError(HttpStatus.BAD_REQUEST ,e.getMessage()));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResponseError> handleGenericException(Exception e) {
        return error(new ResponseError(HttpStatus.FORBIDDEN ,"Something went wrong. Please contact System Administrator"));
    }

    private ResponseEntity<ResponseError> error(ResponseError responseError) {
        return new ResponseEntity<>(responseError, responseError.getStatus());
    }
}
