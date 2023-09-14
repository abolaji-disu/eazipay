package com.eazipay.eazipaytask.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WebhookRequest {

    private String name;
    private String color;
}
