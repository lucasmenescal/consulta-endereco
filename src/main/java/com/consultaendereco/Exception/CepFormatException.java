package com.consultaendereco.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CepFormatException extends RuntimeException {

    public CepFormatException(String message) {
        super(message);
    }

}
