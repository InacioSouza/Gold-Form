import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Cidade } from 'src/app/dominio/Cidade';
import { DadosCadastro } from 'src/app/dominio/DadosCadastro';
import { UF } from 'src/app/dominio/UF';
import { LocalidadeService } from 'src/app/shared/services/localidade.service';
import {UsuarioService} from "../../shared/services/usuario.service";

@Component({
  selector: 'app-form-cadastro',
  templateUrl: './form-cadastro.component.html',
  styleUrls: ['./form-cadastro.component.scss']
})
export class FormCadastroComponent implements OnInit {

  dados: DadosCadastro = {
    nome: '',
    idade: '',
    email: '',
    confirmaEmail: '',
    senha: '',
    confirmaSenha: '',
    endereco: {
      cep: '',
      estado: '',
      cidade: '',
      bairro: '',
      rua: '',
      numero: '',
      complemento: ''
    }
  };

  ufs: UF[] = [];
  cidades: Cidade[] = [];

  constructor(private localidade: LocalidadeService, private toastr: ToastrService, private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.localidade.listaUF().subscribe(resposta => {
      this.ufs = resposta.map(uf => new UF(uf.sigla, uf.nome));
    });
  }

  carregaCidades(event: any) {
    const uf: string = (event.target as HTMLSelectElement).value;
    this.localidade.carregaCidades(uf).subscribe(resposta => {
      this.cidades = resposta.map(municipio => new Cidade(municipio.nome))
    })
  }

  preencheEnderecoPorCEP(event: any) {
    const cep: string = (event.target as HTMLInputElement).value;

    if (!this.cepValido(cep)) {
      return;
    }

    this.localidade.dadosPorCEP(cep).subscribe(resposta => {
      this.dados.endereco.estado = resposta.uf;
      this.dados.endereco.cidade = resposta.localidade;
      this.dados.endereco.bairro = resposta.bairro;
      this.dados.endereco.rua = resposta.logradouro;
    })
  }

  cepValido(cep: string): boolean {
    if (cep === '' || cep.length != 8 || !/^\d+$/.test(cep)) {
      console.log('retornei!')
      return false;
    }
    return true;
  }

  cadastrar(formValido: boolean | null) {
    if (formValido === false) {
      this.toastr.error('Dados incorretos, verifique os campos!', 'Erro');
    }

    this.usuarioService.cadastrar(this.dados).subscribe(usuario => {
      this.toastr.success('Cadastro efetuado com sucesso!', 'Sucesso');
    }, err => {
      this.toastr.error('Erro ao efetuar cadastro, tente novamente!', 'Erro');
    })
  }
}
