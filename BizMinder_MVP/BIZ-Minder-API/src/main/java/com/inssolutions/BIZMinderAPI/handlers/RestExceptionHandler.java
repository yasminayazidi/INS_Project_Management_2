package com.inssolutions.BIZMinderAPI.handlers;

import com.inssolutions.BIZMinderAPI.DTO.ErrorDto;
import com.inssolutions.BIZMinderAPI.enumeration.ErrorCode;
import com.inssolutions.BIZMinderAPI.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

public class RestExceptionHandler {
    final HttpStatus notFound = HttpStatus.NOT_FOUND;
    final ResponseEntity<ErrorDto> handlerException(EntityNotFoundException exception, WebRequest webRequest){

        ErrorDto errorDto= ErrorDto.builder()
                    .httpCode(notFound.value())
                    .message(exception.getMessage())
                    .code(exception.getErrorCode())
                    .build();
        return new ResponseEntity<>(errorDto,notFound);
    }
}
