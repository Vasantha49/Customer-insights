package com.bank.customer_insights.repositories;

import com.bank.customer_insights.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}