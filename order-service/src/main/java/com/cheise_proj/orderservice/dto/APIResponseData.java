package com.cheise_proj.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponseData<T> {
    @Builder.Default
    private boolean success = true;
    private T data;
    private List<APIError> errors;

}
