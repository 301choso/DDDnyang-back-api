package com.dddn.DDDnyang.exception;

import com.dddn.DDDnyang.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse invalidRequestHandler(MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = null;
        if(e.hasErrors()) {
            errorResponse = new ErrorResponse("400", "잘못된 요청입니다.");
            for(FieldError fieldError : e.getFieldErrors()) {
                errorResponse.addValidation(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }
        return errorResponse;
    }
}
