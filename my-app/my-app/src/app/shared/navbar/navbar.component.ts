import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: false,
  templateUrl: './navbar.component.html',
  styleUrls: []
})
export class NavbarComponent {
  constructor(private router: Router) {}
  logout() {
    console.log('User logged out');
    // Here you can redirect or call auth service
    this.router.navigate(['/login']);
  }
}
