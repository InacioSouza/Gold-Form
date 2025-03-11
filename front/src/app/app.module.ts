import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormCadastroComponent } from './pages/form-cadastro/form-cadastro.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CheckValueDirective } from './shared/diretivas/check-value.directive';
import { HttpClientModule } from '@angular/common/http';
import { FormLoginComponent } from './pages/form-login/form-login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    FormCadastroComponent,
    CheckValueDirective,
    FormLoginComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      timeOut: 4000,
      positionClass: 'toast-top-right',
      preventDuplicates: true,
    }),
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
