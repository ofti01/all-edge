package com.lotfi.client;

import com.lotfi.client.dtos.ClientDto;
import com.lotfi.client.services.ClientService;
import feign.Feign;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.clientconfig.FeignClientConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@EnableEurekaClient
public class ClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner stat(ClientService clientService){
        return Args -> {
            clientService.saveClient(new ClientDto(null,"lotfi","zaidi",null,"0741554","SINGLE"));
        };
    }

}
