package com.nwt.witcher.paymentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/clients/{applicationName}")
    public @ResponseBody
    ResponseEntity<String> getClientsByApplicationName(@PathVariable String applicationName) {
        return ResponseEntity.ok(this.discoveryClient.getInstances(applicationName).get(0).getUri().toString());
    }
}
