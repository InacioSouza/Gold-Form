import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {DadosCadastro} from "../../dominio/DadosCadastro";
import {Observable} from "rxjs";
import {Usuario} from "../../dominio/Usuario";

@Injectable({
    providedIn: 'root'
})
export class UsuarioService {

    constructor(private http: HttpClient) {}

    cadastrar(dadosCadastro: DadosCadastro): Observable<Usuario> {
        return this.http.post<Usuario>('http://localhost:8080/auth/register', dadosCadastro);
    }
}