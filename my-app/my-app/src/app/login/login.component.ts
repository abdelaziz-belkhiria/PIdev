import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private router: Router) {}

  login() {
    // For now, simple console check
    console.log('Email:', this.email);
    console.log('Password:', this.password);

    // Redirect to home after login
    this.router.navigate(['/']);
  }
}
