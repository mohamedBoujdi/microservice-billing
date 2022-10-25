package com.example.bellingservice.Dtos;

import com.example.bellingservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseDTO {
    private String id;
    private Date date;
    private Double amount;
    @OneToOne// this is not a column in the database
    private Customer customer;
}
