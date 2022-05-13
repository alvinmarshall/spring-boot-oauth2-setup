package com.cheise_proj.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto implements Serializable {
    private String username;
    private String email;
    private String password;
    @JsonProperty("business_unit")
    private String businessUnit;
    private String role;
}
