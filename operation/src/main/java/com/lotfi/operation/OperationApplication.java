package com.lotfi.operation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
        scanBasePackages = {
                "com.amigoscode.operation"
        }
)
@EnableEurekaClient
@PropertySources({
        @PropertySource("classpath:commons-${spring.profiles.active}.properties")
})
public class OperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperationApplication.class, args);
    }

}
