package com.nwt.witcher.paymentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PaymentappServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentappServiceApplication.class, args);
    }

}
