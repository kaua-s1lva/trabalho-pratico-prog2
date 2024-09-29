package model;

public class ProdutoAlimento extends Produto {
    private String data_validade;

    public ProdutoAlimento (String nome, double preco, int quantidade, String data_validade) {
        super(nome, preco, quantidade);
        this.data_validade = data_validade;
    }

    public void setData_validade (String data_validade) {
        this.data_validade = data_validade;
    }

    public String getData_validade () {
        return data_validade;
    }

    public String toString () {
        return "Nome: " + this.getNome() + ", Preço: " + this.getPreco() + ", Quantidade: " + this.getQuantidade() + ", Data de Validade: " + data_validade + "\n";
    }
}
