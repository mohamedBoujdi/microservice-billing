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
public class InvoiceRequestDTO {
    private String id;
    private Date date;
    private BigDecimal amount;
    private String customerID;
}
