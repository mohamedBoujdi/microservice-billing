package com.example.bellingservice.repository;

import com.example.bellingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    List<Invoice> findByCustomerID(String customerID);
    // this is a query method that will be translated to a query in the database
    // select * from invoice where customerID = ? order by date desc
}
