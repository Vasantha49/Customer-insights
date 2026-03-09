import { Routes } from '@angular/router';
import { LoginComponent } from './login/login';
import { CustomersListComponent } from './customers-list/customers-list';
import { AuthGuard } from './guards/auth-guard';
import {RegisterComponent} from './register/register';

export const routes: Routes = [
  { path: '', redirectTo: 'register', pathMatch: 'full' },  // <-- FIXED
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'customers', component: CustomersListComponent, canActivate: [AuthGuard] },
  { path: '**', redirectTo: 'register' }
];
