package com.lotfi.client;

import com.lotfi.client.dtos.ClientDto;
import com.lotfi.client.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.alledge.client",
                "com.alledge.amqp",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.alledge.client"
)
@PropertySources({
        @PropertySource("classpath:commmons-${spring.profiles.active}.properties")
})
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
