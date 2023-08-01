package com.namsalmert.enoca_challange.exception;
import lombok.Getter;

@Getter
public class EnocaException extends RuntimeException{
    private final EErrorType EErrorType;

    public EnocaException(EErrorType EErrorType){
        super(EErrorType.getMessage());
        this.EErrorType = EErrorType;
    }


    public EnocaException(EErrorType EErrorType, String message){
        super(message);
        this.EErrorType = EErrorType;
    }


}