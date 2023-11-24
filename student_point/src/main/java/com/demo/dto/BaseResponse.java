package com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private String message;
    private Object data;

    public static BaseResponse of(String message, Object data) {
        return BaseResponse.builder()
                .message(message)
                .data(data)
                .build();
    }
}
