package com.ngari.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableDiscoveryClient
//@EnableScheduling
public class UcenterApplication {

	public static void main(String[] args) throws InterruptedException{
        SpringApplication.run(UcenterApplication.class, args);
	}

}
