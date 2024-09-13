package com.codework.dream_shops.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//Class to return data to the front-end
public class ApiResponse {
    private String message;
    private Object data;
}
