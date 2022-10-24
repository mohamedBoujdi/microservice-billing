package com.example.bellingservice.web;


import com.example.bellingservice.Dtos.InvoiceRequestDTO;
import com.example.bellingservice.Dtos.InvoiceResponseDTO;
import com.example.bellingservice.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceController {
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String id){
        return invoiceService.getInvoice(id);
    }

    @GetMapping(path = "/invoices/{CustomerID}")
    public List<InvoiceResponseDTO> getInvoicesByCustomer(@PathVariable(name = "CustomerID") String id){
        return invoiceService.getInvoicesByCustomerID(id);
    }

    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.save(invoiceRequestDTO);
    }
}
