package com.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class BaseErrorException extends RuntimeException{
    private String message;
    private String errKey;
}
