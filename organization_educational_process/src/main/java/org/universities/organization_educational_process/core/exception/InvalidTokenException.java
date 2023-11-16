package org.universities.organization_educational_process.core.exception;

public class InvalidTokenException extends Exception {
    public InvalidTokenException() {
        super();
    }

    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
