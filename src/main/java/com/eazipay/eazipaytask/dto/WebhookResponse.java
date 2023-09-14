package com.eazipay.eazipaytask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebhookResponse {

    private String message;
    private String status;
}
