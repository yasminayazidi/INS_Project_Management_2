package com.inssolutions.BIZMinderAPI.exception;

import com.inssolutions.BIZMinderAPI.enumeration.ErrorCode;
import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{
    @Getter
    private ErrorCode errorCode;
    public EntityNotFoundException( String message){
        super(message);
    }
    public EntityNotFoundException( String message, Throwable cause){
        super(message, cause);
    }
    public EntityNotFoundException( String message, Throwable cause , ErrorCode errorCode){
        super(message, cause);
        this.errorCode=errorCode;
    }
}
