package com.eazipay.eazipaytask.service;

import com.eazipay.eazipaytask.dto.WebhookRequest;
import com.eazipay.eazipaytask.dto.WebhookResponse;
import org.springframework.stereotype.Service;

@Service
public class SchemaWatcherImpl implements SchemaWatcherService {


    @Override
    public WebhookResponse processTrigger(WebhookRequest req) {
        return WebhookResponse.builder()
                .status("200")
                .message("Great")
                .build();
    }
}
