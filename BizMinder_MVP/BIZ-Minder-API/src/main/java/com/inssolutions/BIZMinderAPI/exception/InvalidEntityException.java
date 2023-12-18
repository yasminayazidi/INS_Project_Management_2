package com.inssolutions.BIZMinderAPI.exception;

import com.inssolutions.BIZMinderAPI.enumeration.ErrorCode;
import lombok.Getter;

import java.util.List;

@Getter
public class InvalidEntityException extends RuntimeException{
    private ErrorCode errorCode;

    private List<String> errors;
    public InvalidEntityException( String message){
        super(message);
    }
    public InvalidEntityException( String message, Throwable cause){
        super(message, cause);
    }
    public InvalidEntityException(String message, ErrorCode errorCode, List<String> errors){
        super(message);
        this.errorCode=errorCode;
        this.errors =errors;
    }
}
