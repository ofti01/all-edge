package com.lotfi.compte;

import com.lotfi.compte.dtos.CompteCourantDto;
import com.lotfi.compte.services.CompteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.alledge.compte",
                "com.alledge.amqp",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.alledge.compte"
)
@PropertySources({
        @PropertySource("classpath:commons-${spring.profiles.active}.properties")
})
public class CompteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(CompteService compteService){
        return Args -> {
           compteService.SaveCompteCourant(new CompteCourantDto("null","07512641",120.000,2000));
        };
    }

}
