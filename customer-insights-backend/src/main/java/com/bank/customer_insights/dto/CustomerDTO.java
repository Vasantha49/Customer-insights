package com.bank.customer_insights.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public LocalDate dateOfBirth;
    public String riskCategory;
}