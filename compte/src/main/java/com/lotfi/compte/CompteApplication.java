package com.lotfi.compte;

import com.lotfi.compte.dtos.CompteCourantDto;
import com.lotfi.compte.services.CompteService;
import feign.Feign;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@LoadBalancerClient(name = "client-service")
public class CompteApplication {


    @Bean
    @Scope("prototype")
    @LoadBalanced
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
    public static void main(String[] args) {
        SpringApplication.run(CompteApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(CompteService compteService){
        return Args -> {
           compteService.SaveCompteCourant(new CompteCourantDto("null","0741554",120.000,2000));
        };
    }

}
