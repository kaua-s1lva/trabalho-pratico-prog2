package model;

public class ProdutoEletronico extends Produto {
    private String marca;
    private String modelo;

    public ProdutoEletronico (String marca, String modelo, String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
        this.marca = marca;
        this.modelo = modelo;
    }

    public void setMarca (String marca) {
        this.marca = marca;
    }

    public void setModelo (String modelo) {
        this.modelo = modelo;
    }

    public String getMarca () {
        return marca;
    }

    public String getModelo () {
        return modelo;
    }

    public String toString () {
        return "Nome: " + this.getNome() + ", Preço: " + this.getPreco() + ", Quantidade: " + this.getQuantidade() + ", Marca: " + marca + ", Modelo: " + modelo + "\n";
    }
}
