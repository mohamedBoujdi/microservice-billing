package com.example.bellingservice.service;

import com.example.bellingservice.Dtos.InvoiceRequestDTO;
import com.example.bellingservice.Dtos.InvoiceResponseDTO;
import com.example.bellingservice.entities.Customer;
import com.example.bellingservice.entities.Invoice;
import com.example.bellingservice.mapper.InvoiceMapper;
import com.example.bellingservice.openFiegn.CustomerRestClient;
import com.example.bellingservice.repository.InvoiceRepository;
import com.example.bellingservice.service.InvoiceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
                              InvoiceMapper invoiceMapper,
                              CustomerRestClient customerRestClient  ) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setCustomer(customerRestClient.getCustomerById(invoiceRequestDTO.getCustomerID()));
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String id) {
        Invoice invoice = invoiceRepository.findById(id).get();
        Customer customer = customerRestClient.getCustomerById(invoice.getCustomer().getId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> getInvoicesByCustomerID(String customerID) {
        List<Invoice> invoicesByCustomerID = invoiceRepository.findByCustomerID(customerID);
        return invoicesByCustomerID.stream().map(invoiceMapper::fromInvoice).toList();
    }
}
