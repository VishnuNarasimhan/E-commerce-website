package com.example.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryApplication.class, args);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$ APPLICATION STARTED SUCCESSFULLY $$$$$$$$$$$$$$$$$$$$$");
            System.out.println("PORT: http://localhost:8761");
    }

}
