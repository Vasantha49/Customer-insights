import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.html',
  styleUrls: ['./register.css']
})
export class RegisterComponent {

  username = '';
  password = '';

  form = {username: '', email: '', password: ''};

  constructor(private http: HttpClient) {
  }

  register() {
    this.http.post('http://localhost:8080/api/auth/register', this.form)
      .subscribe({
        next: () => alert('User registered!'),
        error: err => alert('Registration failed')
      });
  }
}

