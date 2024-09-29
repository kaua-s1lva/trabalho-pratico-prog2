package controller;

import java.util.Comparator;

import model.Produto;

public class ComparadorProdutoNome implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return p1.getNome().compareTo(p2.getNome());
    }
}
