package com.inssolutions.BIZMinderAPI.enumeration;

public enum ErrorCode {
    // ErrorCode of entreprise let 1000 to 1999
    ENTREPRISE_NOT_FOUND(1000),
    ENTREPRISE_NOT_VALID(1001),
    ENTREPRISE_ALREADY_IN_USE(1002),
    // ErrorCode Address let 2000 to 2999
    //todo
    ;
    private int code;
    ErrorCode(int code){
        this.code = code;
    }
    public int getCode(){
        return  code;
    }

}
