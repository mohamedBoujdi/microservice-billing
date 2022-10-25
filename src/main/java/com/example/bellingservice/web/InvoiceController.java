package com.example.bellingservice.web;


import com.example.bellingservice.Dtos.InvoiceRequestDTO;
import com.example.bellingservice.Dtos.InvoiceResponseDTO;
import com.example.bellingservice.entities.Invoice;
import com.example.bellingservice.repository.InvoiceRepository;
import com.example.bellingservice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceController {
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoice/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String id){
        return invoiceService.getInvoice(id);
        //return invoiceRepository.findById(id).get();
    }

    @GetMapping(path = "/invoice/customer/{CustomerID}")
    public List<InvoiceResponseDTO> getInvoicesByCustomer(@PathVariable(name = "CustomerID") String id){
        return invoiceService.getInvoicesByCustomerID(id);
    }

    @PostMapping(path = "/invoice/add/")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.save(invoiceRequestDTO);
    }
    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> getAllInvoices(){
        return invoiceService.getAllInvoices();
    }
    @DeleteMapping(path = "/invoice/d/{id}")
    public void deleteInvoice(@PathVariable(name = "id") String id){
        invoiceService.deleteInvoice(id);
    }

    @PutMapping(path = "/invoice/up/{id}")
    public InvoiceResponseDTO updateInvoice(@PathVariable(name = "id") String id, @RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.updateInvoice(id, invoiceRequestDTO);
    }

}
