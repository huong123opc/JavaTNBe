package com.demo.dto.response.utils;

import com.demo.dto.BaseResponse;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ResponseUtils {
    public ResponseEntity<BaseResponse> created(Object obj) {
        return new ResponseEntity<>(BaseResponse.of("Created", obj), HttpStatus.CREATED);
    }

    public ResponseEntity<BaseResponse> created() {
        return new ResponseEntity<>(BaseResponse.of("Created", null), HttpStatus.CREATED);
    }

    public ResponseEntity<BaseResponse> ok() {
        return ResponseEntity.ok(BaseResponse.of(StringUtils.EMPTY, null));
    }

    public ResponseEntity<BaseResponse> ok(String msg) {
        return ResponseEntity.ok(BaseResponse.of(msg, null));
    }

    public ResponseEntity<BaseResponse> ok(Object data) {
        return ResponseEntity.ok(BaseResponse.of(StringUtils.EMPTY, data));
    }

    public ResponseEntity<BaseResponse> ok(String msg, Object data) {
        return ResponseEntity.ok(BaseResponse.of(msg, data));
    }

}
