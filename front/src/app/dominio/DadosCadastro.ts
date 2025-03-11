import { Endereco } from "./Endereco";

export class DadosCadastro {
    constructor(
        public nome: string,
        public idade: string,
        public email: string,
        public confirmaEmail: string,
        public senha: string,
        public confirmaSenha: string,
        public endereco: Endereco
    ) { }
} 