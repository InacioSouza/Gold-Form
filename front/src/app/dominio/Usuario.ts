import {Endereco} from "./Endereco";

export class Usuario {
    constructor(public id: number,
                public nome: string,
                public idade: number,
                public email: string,
                public endereco: Endereco) {
    }
}