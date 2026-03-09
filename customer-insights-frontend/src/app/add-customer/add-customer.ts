import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService, Customer } from '../services/customer';

@Component({
  selector: 'app-add-customer',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-customer.html',
  styleUrls: ['./add-customer.css']
})
export class AddCustomerComponent {

  customer: Customer = {
    firstName: '',
    lastName: '',
    email: '',
    phoneNumber: '',
    dateOfBirth: '',
    riskCategory: ''
  };

  constructor(private customerService: CustomerService, private router: Router) {}

  save(): void {
    this.customerService.create(this.customer).subscribe(() => {
      this.router.navigate(['/customers']);
    });
  }
}
