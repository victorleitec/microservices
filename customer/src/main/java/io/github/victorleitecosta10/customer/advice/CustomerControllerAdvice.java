package io.github.victorleitecosta10.customer.advice;

import io.github.victorleitecosta10.customer.exception.ApiErrors;
import io.github.victorleitecosta10.customer.exception.EmailAlreadyTakenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerControllerAdvice {

    @ExceptionHandler(EmailAlreadyTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleEmailAlreadyTakenException(EmailAlreadyTakenException ex) {
        return new ApiErrors(ex);
    }
}
