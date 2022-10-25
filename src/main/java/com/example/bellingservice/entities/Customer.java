package com.example.bellingservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@ToString
public class Customer {
    private String id;
    private String name;
    private String email;
}
