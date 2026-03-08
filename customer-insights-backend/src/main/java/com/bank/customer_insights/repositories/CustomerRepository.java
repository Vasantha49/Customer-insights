package com.bank.customer_insights.repositories;

import com.bank.customer_insights.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}