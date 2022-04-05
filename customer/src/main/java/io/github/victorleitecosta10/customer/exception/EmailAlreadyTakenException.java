package io.github.victorleitecosta10.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyTakenException extends RuntimeException {

    public EmailAlreadyTakenException(String errorMessage) {
        super(errorMessage);
    }
}
