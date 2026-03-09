import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerService, Customer } from '../services/customer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customers-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './customers-list.html',
  styleUrls: ['./customers-list.css']
})
export class CustomersListComponent implements OnInit {

  customers: Customer[] = [];

  constructor(private customerService: CustomerService, private router: Router) {}

  ngOnInit(): void {
    this.customerService.getAll().subscribe(data => {
      this.customers = data;
    });
  }

  edit(id: number) {
    this.router.navigate(['/edit-customer', id]);
  }

  delete(id: number) {
    this.customerService.delete(id).subscribe(() => {
      this.customers = this.customers.filter(c => c.id !== id);
    });
  }
}
