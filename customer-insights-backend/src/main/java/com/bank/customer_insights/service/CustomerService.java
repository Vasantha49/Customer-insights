package com.bank.customer_insights.service;

import com.bank.customer_insights.dto.CustomerDTO;
import com.bank.customer_insights.model.Customer;
import com.bank.customer_insights.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public CustomerDTO getCustomer(Long id) {
        return customerRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public CustomerDTO createCustomer(CustomerDTO dto) {
        Customer customer = toEntity(dto);
        return toDTO(customerRepository.save(customer));
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setFirstName(dto.firstName);
        customer.setLastName(dto.lastName);
        customer.setEmail(dto.email);
        customer.setPhoneNumber(dto.phoneNumber);
        customer.setDateOfBirth(dto.dateOfBirth);
        customer.setRiskCategory(dto.riskCategory);
        return toDTO(customerRepository.save(customer));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO toDTO(Customer c) {
        CustomerDTO dto = new CustomerDTO();
        dto.id = c.getId();
        dto.firstName = c.getFirstName();
        dto.lastName = c.getLastName();
        dto.email = c.getEmail();
        dto.phoneNumber = c.getPhoneNumber();
        dto.dateOfBirth = c.getDateOfBirth();
        dto.riskCategory = c.getRiskCategory();
        return dto;
    }

    private Customer toEntity(CustomerDTO dto) {
        Customer c = new Customer();
        c.setFirstName(dto.firstName);
        c.setLastName(dto.lastName);
        c.setEmail(dto.email);
        c.setPhoneNumber(dto.phoneNumber);
        c.setDateOfBirth(dto.dateOfBirth);
        c.setRiskCategory(dto.riskCategory);
        return c;
    }
}