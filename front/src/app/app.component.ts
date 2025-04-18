import { Component } from '@angular/core';
import {TokenExpirationService} from "./shared/services/auth/token.expiration.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'gold-form';

  constructor(private tokenExpirationService: TokenExpirationService) {
    this.tokenExpirationService.startTokenMonitor();
  }


}
