package com.profectusweb.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class UserRequest {

    @NotEmpty(message = "Username cannot be empty")
    @Length(max = 60)
    public String username;

    @NotEmpty(message = "Password cannot be empty")
    @Length(max = 128)
    public String password;
}
