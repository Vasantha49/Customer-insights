import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CustomerService, Customer } from '../services/customer';

@Component({
  selector: 'app-edit-customer',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-customer.html',
  styleUrls: ['./edit-customer.css']
})
export class EditCustomerComponent implements OnInit {

  customerId!: number;
  customer!: Customer;

  constructor(
    private route: ActivatedRoute,
    private customerService: CustomerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.customerId = Number(this.route.snapshot.paramMap.get('id'));
    this.customerService.getById(this.customerId).subscribe(c => this.customer = c);
  }

  update(): void {
    this.customerService.update(this.customerId, this.customer).subscribe(() => {
      this.router.navigate(['/customers']);
    });
  }
}
