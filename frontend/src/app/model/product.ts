export class Product {

    constructor (
        public nome: string,
        public veiculoAplicacao: string,
        public pesoLiquido: number,
        public pesoBruto: number,
        public createdAt: Date,
        public updatedAt: Date,
        public id?: number
    ) {}
}
