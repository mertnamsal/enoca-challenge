package com.namsalmert.enoca_challange.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EErrorType {
    INTERNAL_ERROR(3000,"Unexpected error on server",INTERNAL_SERVER_ERROR),
    INVALID_TOKEN(4001,"Invalid token information",BAD_REQUEST),
    BAD_REQUEST_ERROR(1202,"You have entered an invalid parameter",BAD_REQUEST),
    SCHOOL_NOT_FOUND(2100,"School not found",BAD_REQUEST),
    SCHOOL_ALREADY_EXISTS(2101,"School already exists",BAD_REQUEST),
    TEACHER_NOT_FOUND(2200,"Teacher not found",BAD_REQUEST),
    TEACHER_ALREADY_EXISTS(2201,"Teacher already exists",BAD_REQUEST),
    SCHOOL_HAS_TEACHERS(2201,"School has teachers",BAD_REQUEST),


    ;

    private int code;
    private String message;
    private HttpStatus httpStatus;
}
