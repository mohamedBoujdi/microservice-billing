package com.example.bellingservice.Dtos;

import com.example.bellingservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseDTO {
    private BigDecimal amount;
    private Customer customer;
}
