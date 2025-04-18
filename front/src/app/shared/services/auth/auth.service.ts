import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url = 'http://localhost:8080/auth/login';
  private jwtHelper = new JwtHelperService();

  constructor(private http: HttpClient, private router: Router, private toastr: ToastrService) { }

  login(email: string, senha: string) {
    return this.http.post<{ token: string }>(this.url, { email, senha }, {
      withCredentials: true
    }).subscribe({
        next: (response) => {
          localStorage.setItem('token', response.token);
          this.router.navigate(['/dashboard']);
        },
        error: (err) => {
          console.log(err);
          this.toastr.error('Erro ao efetuar login, verifique se os dados estão corretos!', 'Erro')
        }
      });
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }

  isAuthenticated(): boolean {
    const token = localStorage.getItem('token');

    if (!token) return false

    if (this.jwtHelper.isTokenExpired(token)) {
      this.logout();
      return false;
    }

    return true;
  }

}
