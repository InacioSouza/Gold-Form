import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormCadastroComponent } from './pages/form-cadastro/form-cadastro.component';
import { FormLoginComponent } from './pages/form-login/form-login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

const routes: Routes = [
  { path: 'cadastro', component: FormCadastroComponent },
  { path: 'login', component: FormLoginComponent },
  { path: 'dashboard', component: DashboardComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
