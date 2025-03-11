export class Endereco {
    constructor(
        public cep: string,
        public estado: string,
        public cidade: string,
        public bairro: string,
        public rua: string,
        public numero: string,
        public complemento: string
    ) {

    }
}