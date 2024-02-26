package com.lotfi.operation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
        scanBasePackages = {
                "com.lotfi.operation"
        }
)

@PropertySources({
        @PropertySource("classpath:commons-${spring.profiles.active}.properties")
})
public class OperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperationApplication.class, args);
    }

}
