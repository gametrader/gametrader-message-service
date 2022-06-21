package com.gametrader.gametradermessageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GametraderMessageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GametraderMessageServiceApplication.class, args);
    }

}
