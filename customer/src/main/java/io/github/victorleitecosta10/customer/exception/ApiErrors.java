package io.github.victorleitecosta10.customer.exception;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class ApiErrors {

    private final List<String> errors;

    public ApiErrors(BindingResult bindingResult) {
        this.errors = new ArrayList<>();
        bindingResult.getAllErrors().forEach(objectError -> this.errors.add(objectError.getDefaultMessage()));
    }

    public ApiErrors(EmailAlreadyTakenException ex) {
        this.errors = List.of(ex.getMessage());
    }

    public List<String> getErrors() {
        return errors;
    }
}
