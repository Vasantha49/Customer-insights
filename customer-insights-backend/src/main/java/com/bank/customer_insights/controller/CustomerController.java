package com.bank.customer_insights.controller;

import com.bank.customer_insights.dto.CustomerDTO;
import com.bank.customer_insights.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getAll() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getOne(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    public CustomerDTO create(@RequestBody CustomerDTO dto) {
        return customerService.createCustomer(dto);
    }

    @PutMapping("/{id}")
    public CustomerDTO update(@PathVariable Long id, @RequestBody CustomerDTO dto) {
        return customerService.updateCustomer(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}