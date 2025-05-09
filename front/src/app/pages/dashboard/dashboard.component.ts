import { Component } from '@angular/core';
import {AuthService} from "../../shared/services/auth/auth.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {

  constructor(private authService: AuthService) { }

  logout(): void {
    this.authService.logout();
  }
}
