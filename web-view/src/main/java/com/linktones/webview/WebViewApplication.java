package com.linktones.webview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WebViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebViewApplication.class, args);
    }

}
