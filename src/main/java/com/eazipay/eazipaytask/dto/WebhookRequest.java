package com.eazipay.eazipaytask.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WebhookRequest {

    private List<String> allUpdatedProperties = new ArrayList<>();

}
