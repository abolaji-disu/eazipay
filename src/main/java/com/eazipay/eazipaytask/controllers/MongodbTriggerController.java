package com.eazipay.eazipaytask.controllers;

import com.eazipay.eazipaytask.dto.WebhookRequest;
import com.eazipay.eazipaytask.dto.WebhookResponse;
import com.eazipay.eazipaytask.service.SchemaWatcherImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
@Slf4j
public class MongodbTriggerController {


    private final SchemaWatcherImpl schemaWatcher;


    @PostMapping(value="webhooks/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebhookResponse> processTrigger(@RequestBody WebhookRequest request){
        log.info("logging request");
        log.info(request.getName() + " " + request.getColor());
        WebhookResponse res = schemaWatcher.processTrigger(request);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
