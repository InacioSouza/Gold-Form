import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class LocalidadeService {

  constructor(private http: HttpClient) { }

  listaUF() {
    return this.http.get<any[]>('https://servicodados.ibge.gov.br/api/v1/localidades/estados');
  }

  carregaCidades(uf: string) {
    return this.http.get<any[]>(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${uf}/municipios`)
  }

  dadosPorCEP(cep: string) {
    return this.http.get<any>(`https://viacep.com.br/ws/${cep}/json/`);
  }
}
