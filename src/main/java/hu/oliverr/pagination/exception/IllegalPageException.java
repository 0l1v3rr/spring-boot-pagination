package hu.oliverr.pagination.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalPageException extends RuntimeException {

    public IllegalPageException() {
        super("The page must be greater than 0!");
    }

}
