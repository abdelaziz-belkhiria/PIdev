import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: false,
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  fullName: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';

  constructor(private router: Router) {}

  register() {
    if (!this.fullName || !this.email || !this.password || !this.confirmPassword) {
      alert('Please fill all fields!');
      return;
    }

    if (this.password !== this.confirmPassword) {
      alert('Passwords do not match!');
      return;
    }

    console.log('Full Name:', this.fullName);
    console.log('Email:', this.email);
    console.log('Password:', this.password);

    // Redirect to login after registration
    alert('Account created successfully!');
    this.router.navigate(['/login']);
  }
}
