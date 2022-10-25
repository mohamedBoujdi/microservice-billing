package com.example.bellingservice.service;

import com.example.bellingservice.Dtos.InvoiceRequestDTO;
import com.example.bellingservice.Dtos.InvoiceResponseDTO;
import com.example.bellingservice.entities.Invoice;

import java.util.List;

public interface InvoiceService {
     InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
     InvoiceResponseDTO getInvoice(String id);
     List<InvoiceResponseDTO> getInvoicesByCustomerID(String customerID);

     //all invoices
     List<InvoiceResponseDTO> getAllInvoices();

     //delete invoice
     void deleteInvoice(String id);

     //update invoice
     InvoiceResponseDTO updateInvoice(String id, InvoiceRequestDTO invoiceRequestDTO);
}
