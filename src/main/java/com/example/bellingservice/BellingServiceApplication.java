package com.example.bellingservice;

import com.example.bellingservice.Dtos.InvoiceRequestDTO;
import com.example.bellingservice.openFiegn.CustomerRestClient;
import com.example.bellingservice.service.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient // Enable eureka client.
@EnableFeignClients //enable feign client to call customer service from invoice service
public class BellingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BellingServiceApplication.class, args);
    }


    //@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner start(InvoiceService invoiceService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                invoiceService.save(new InvoiceRequestDTO( 1000.0, "76GY"));
                invoiceService.save(new InvoiceRequestDTO(2000.0, "57BK"));
                invoiceService.save(new InvoiceRequestDTO( 3000.0, "98JH"));
                invoiceService.save(new InvoiceRequestDTO(4000.0, "45GH"));
                invoiceService.save(new InvoiceRequestDTO(5000.0, "78JH"));
            }
        };

    }

}
