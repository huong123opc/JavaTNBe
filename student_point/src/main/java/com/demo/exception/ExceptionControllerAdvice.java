package com.demo.exception;

import com.demo.dto.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<BaseResponse> unknownErrorHandler(Exception e) {
        log.error("Unexpected Exception", e);
        String errMsg = "Unknown Error";
        return new ResponseEntity<>(new BaseResponse(errMsg, null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BaseErrorException.class})
    public ResponseEntity<BaseResponse> BaseErrorHandler(BaseErrorException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new BaseResponse(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
