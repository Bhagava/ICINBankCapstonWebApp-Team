package com.springboot.web.app.bank.customexceptions;

/**
 * Exception thrown when the account is invalid due to some reason
 *
 */
public class InvalidAccountException extends RuntimeException {

    public InvalidAccountException(String message) {
        super(message);
    }
}
