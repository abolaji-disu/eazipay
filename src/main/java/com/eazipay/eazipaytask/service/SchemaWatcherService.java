package com.eazipay.eazipaytask.service;

import com.eazipay.eazipaytask.dto.WebhookRequest;
import com.eazipay.eazipaytask.dto.WebhookResponse;

public interface SchemaWatcherService {

    public WebhookResponse processTrigger (WebhookRequest req);
}
