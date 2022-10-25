package com.example.bellingservice.openFiegn;

import com.example.bellingservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
//bean for feign client to call customer service
@FeignClient(name = "CUSTOMER-SERVICE")
//cette annotation permet de dire que cette interface est un client feign
// cad qu'elle va appeler un service rest
public interface CustomerRestClient {
    @GetMapping(path = "/Api/customers/{id}")
    Customer getCustomerById(@PathVariable(name = "id") String id);
    @GetMapping(path = "/Api/customers")
    List<Customer> customers();
}
