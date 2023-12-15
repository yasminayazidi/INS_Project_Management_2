package com.inssolutions.BIZMinderAPI.DTO;

import com.inssolutions.BIZMinderAPI.enumeration.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private int httpCode; // 200 - 202
    private String message; // read information is OK - update a la base
    private ErrorCode code; // OK - validate
    private List<String> errors = new ArrayList<>();
}
