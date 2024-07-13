package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Orders_Service_16002 {
    public static void main(String[] args) {
        SpringApplication.run(Orders_Service_16002.class,args);
    }
}