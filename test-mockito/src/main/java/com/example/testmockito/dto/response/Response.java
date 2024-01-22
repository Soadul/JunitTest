package com.example.testmockito.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {
    private int statusCode;
    private boolean isSuccess;
    private String message;
    private T data;


}
