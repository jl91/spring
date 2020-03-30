package com.profectusweb.exception;

import java.math.BigInteger;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(BigInteger id) {
        super(String.format("User not found for Id: %s", id));
    }
}
