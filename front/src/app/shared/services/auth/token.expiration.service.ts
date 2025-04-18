import {Injectable} from "@angular/core";
import {AuthService} from "./auth.service";
import {Router} from "@angular/router";

@Injectable({
    providedIn: 'root'
})
export class TokenExpirationService {
    private checkInterval = 5 * 1000;
    private intervalId: any;
    
    constructor(private authService: AuthService, private router: Router) {}
    
    startTokenMonitor() {
        this.intervalId = setInterval(() => {
            if(!this.authService.isAuthenticated()){

                if(this.router.url === '/login' || this.router.url === '/cadastro'){
                    return;
                }

                this.authService.logout();
            }
        }, this.checkInterval);
    }

    stopTokenMonitor() {
        clearInterval(this.intervalId);
    }
}