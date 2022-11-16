package hu.oliverr.pagination.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadAuthorException extends RuntimeException {

    public BadAuthorException() {
        super("Please provide a valid author!");
    }

    public BadAuthorException(String message) {
        super(message);
    }

}
