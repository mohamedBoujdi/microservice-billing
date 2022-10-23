package com.example.bellingservice.openFiegn;

import com.example.bellingservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path = "/Api/customers/{id}")
    Customer getCustomerById(@PathVariable(name = "id") String id);
    @GetMapping(path = "/Api/customers")
    List<Customer> customers();
}
