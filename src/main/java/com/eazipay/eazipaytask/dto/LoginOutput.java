package com.eazipay.eazipaytask.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginOutput {

    private String token;

    private String message;
}
