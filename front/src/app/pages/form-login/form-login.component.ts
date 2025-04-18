import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/shared/services/auth/auth.service';


@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.scss']
})
export class FormLoginComponent {

  formLogin!: FormGroup;


  constructor(private formBuilder: FormBuilder, private toastr: ToastrService, private authService: AuthService) {
    this.formLogin = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required]]
    });
  }

  isInvalid(campo: string) {
    return (!this.formLogin.get(campo)?.valid && this.formLogin.get(campo)?.touched) as boolean;
  }

  login() {
    if (this.formLogin.invalid) {
      this.toastr.error('Verifique se os campos estão corretos!', 'Erro');
      return;
    }

    this.authService.login(this.formLogin.get('email')?.value, this.formLogin.get('senha')?.value);
  }
}
