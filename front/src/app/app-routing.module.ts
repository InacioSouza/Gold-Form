import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormCadastroComponent } from './pages/form-cadastro/form-cadastro.component';
import { FormLoginComponent } from './pages/form-login/form-login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { authGuard } from './shared/services/auth/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  { path: 'cadastro', component: FormCadastroComponent },
  { path: 'login', component: FormLoginComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [authGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
