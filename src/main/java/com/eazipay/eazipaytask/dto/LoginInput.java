package com.eazipay.eazipaytask.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginInput {

    @NotEmpty(message = "Field cannot be null or empty")
    private String email;

    @NotEmpty(message = "Field cannot be null or empty")
    private String password;


}
