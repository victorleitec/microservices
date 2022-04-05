package io.github.victorleitecosta10.customer.request;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class CustomerRegistrationRequest {

    private String firstName;
    private String lastName;

    @Email
    private String email;
}
