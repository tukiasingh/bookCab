package com.example.bookcab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookCabApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookCabApplication.class, args);
    }

}
