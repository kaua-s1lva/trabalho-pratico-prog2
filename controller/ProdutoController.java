package controller;

import view.ProdutoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Produto;
import model.ProdutoAlimento;
import model.ProdutoEletronico;

public class ProdutoController {
    private ProdutoView janela;
    ArrayList<Produto> produtos = new ArrayList<Produto>();
   
    public ProdutoController(){

        janela = new ProdutoView();
        
        JButton adicionarProduto = janela.getAdicionarJButton();
        JButton listarProdutos = janela.getListarNaoOrdemJButton();
        JButton listarProdutosOrdem = janela.getListarOrdemJButton();
        JButton removerProduto = janela.getRemoverJButton();
        JButton editarProduto = janela.getEditarJButton();
        JButton pesquisarProduto = janela.getPesquisarJButton();
        
        adicionarProduto.addActionListener(new ActionListener(){
     
            @Override
            public void actionPerformed(ActionEvent e){
                adicionarProdutoEvent();
            }
        });

        listarProdutos.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProdutosEvent();
            }
        });

        listarProdutosOrdem.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProdutosOrdemEvent();
            }
        });

        removerProduto.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                removerProdutoEvent();
            }
        });

        editarProduto.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                editarProdutoEvent();
            }
        });

        pesquisarProduto.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarProdutoEvent();
            }
        });
       
    }
    
    private void adicionarProdutoEvent() {

        Produto produto;
        
        try {
            String opcao = janela.getTipoProdutoJComboBox().getSelectedItem().toString();
            String nome = janela.getNomeJTextField().getText();
            Double preco = Double.parseDouble(janela.getPrecoJTextField().getText());
            Integer quantidade = Integer.parseInt(janela.getQuantJTextField().getText());
            String marca = janela.getMarcaJTextField().getText();
            String modelo = janela.getModeloJTextField().getText();
            String dataValidade = janela.getDataValidadeJTextField().getText();
            
            if (opcao.equals("Alimento")) {
                produto = new ProdutoAlimento(nome, preco, quantidade, dataValidade);
            } else {
                produto = new ProdutoEletronico(marca, modelo, nome, preco, quantidade);
            }

            produtos.add(produto);

            JOptionPane.showMessageDialog(janela, "Produto adicionado com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(janela, e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarProdutosEvent() {
        janela.getListaProdutosJTextArea().setText("");

        for (Produto produto: produtos) {
            janela.getListaProdutosJTextArea().append(produto.toString() + "\n");
        }
    }

    private void listarProdutosOrdemEvent() {
        ArrayList<Produto> tempProdutos = new ArrayList<>();
        Iterator<Produto> it = produtos.iterator();

        while (it.hasNext()) {
            tempProdutos.add(it.next());
        }

        Collections.sort(tempProdutos, new ComparadorProdutoNome());
        janela.getListaProdutosJTextArea().setText("");

        for (Produto tempProduto: tempProdutos) {
            janela.getListaProdutosJTextArea().append(tempProduto.toString() + "\n");
        }
    }

    private void removerProdutoEvent() {
        int pos = -1;
        JLabel nomeJLabel = new JLabel("Nome:");
        JTextField nomeJTextField = new JTextField(10);
        JPanel panel = new JPanel();
        panel.add(nomeJLabel);
        panel.add(nomeJTextField);
        JOptionPane.showMessageDialog(janela, panel, "Remover produto", JOptionPane.QUESTION_MESSAGE);

        for (int i=0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equals(nomeJTextField.getText())) {
                pos = i;
            }
        }

        if (pos == -1) {
            JOptionPane.showMessageDialog(janela, "Produto não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            produtos.remove(pos);
            JOptionPane.showMessageDialog(janela, "Produto removido com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void editarProdutoEvent() {
        int pos = -1;
        String nome = janela.getNomeJTextField().getText();
    
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equals(nome)) {
                pos = i;
            }
        }
    
        if (pos == -1) {
            JOptionPane.showMessageDialog(janela, "Produto não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                JPanel panelNome = new JPanel();
                JLabel nomeLabel = new JLabel("Nome:");
                JTextField nomeField = new JTextField(20);
                panelNome.add(nomeLabel);
                panelNome.add(nomeField);
                JOptionPane.showMessageDialog(janela, panelNome, "Editar Produto", JOptionPane.QUESTION_MESSAGE);
                produtos.get(pos).setNome(nomeField.getText());

                JPanel panelPreco = new JPanel();
                JLabel precoLabel = new JLabel("Preço: ");
                JTextField precoField = new JTextField(20);
                panelPreco.add(precoLabel);
                panelPreco.add(precoField);
                JOptionPane.showMessageDialog(janela, panelPreco, "Editar Produto", JOptionPane.QUESTION_MESSAGE);
                produtos.get(pos).setPreco(Double.parseDouble(precoField.getText()));

                JPanel panelQuant = new JPanel();
                JLabel quantLabel = new JLabel("Quantidade:");
                JTextField quantField = new JTextField(20);
                panelQuant.add(quantLabel);
                panelQuant.add(quantField);
                JOptionPane.showMessageDialog(janela, panelQuant, "Editar Produto", JOptionPane.QUESTION_MESSAGE);
                produtos.get(pos).setQuantidade(Integer.parseInt(quantField.getText()));

                if (produtos.get(pos) instanceof ProdutoAlimento) {
                    ProdutoAlimento produtoAlimento = (ProdutoAlimento) produtos.get(pos);

                    JPanel panelDataValidade = new JPanel();
                    JLabel dataValidadeLabel = new JLabel("Data de Validade:");
                    JTextField dataValidadeField = new JTextField(20);
                    panelDataValidade.add(dataValidadeLabel);
                    panelDataValidade.add(dataValidadeField);
                    JOptionPane.showMessageDialog(janela, panelDataValidade, "Editar Produto", JOptionPane.QUESTION_MESSAGE);
                    produtoAlimento.setData_validade(dataValidadeField.getText());
                } else {
                    ProdutoEletronico produtoEletronico = (ProdutoEletronico) produtos.get(pos);

                    JPanel panelMarca = new JPanel();
                    JLabel marcaLabel = new JLabel("Marca:");
                    JTextField marcaField = new JTextField(20);
                    panelMarca.add(marcaLabel);
                    panelMarca.add(marcaField);
                    JOptionPane.showMessageDialog(janela, panelMarca, "Editar Produto", JOptionPane.QUESTION_MESSAGE);
                    produtoEletronico.setMarca(marcaField.getText());
        
                    JPanel panelModelo = new JPanel();
                    JLabel modeloLabel = new JLabel("Modelo:");
                    JTextField modeloField = new JTextField(20);
                    panelModelo.add(modeloLabel);
                    panelModelo.add(modeloField);
                    JOptionPane.showMessageDialog(janela, panelModelo, "Editar Produto", JOptionPane.QUESTION_MESSAGE);
                    produtoEletronico.setModelo(modeloField.getText());
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(janela, e, "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }

    private void pesquisarProdutoEvent() {
        int pos = -1;
        String nome = janela.getNomeJTextField().getText();
    
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equals(nome)) {
                pos = i;
            }
        }
    
        if (pos == -1) {
            JOptionPane.showMessageDialog(janela, "Produto não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            janela.setNomeJTextField(produtos.get(pos).getNome());
            janela.setPrecoJTextField(produtos.get(pos).getPreco());
            janela.setQuantJTextField(produtos.get(pos).getQuantidade());

            if (produtos.get(pos) instanceof ProdutoAlimento) {
                ProdutoAlimento produtoAlimento = (ProdutoAlimento) produtos.get(pos);
                janela.setDataValidadeJTextField(produtoAlimento.getData_validade());
                janela.setMarcaJTextField("");
                janela.setModeloJTextField("");
            } else {
                ProdutoEletronico produtoEletronico = (ProdutoEletronico) produtos.get(pos);
                janela.setDataValidadeJTextField("");
                janela.setMarcaJTextField(produtoEletronico.getMarca());
                janela.setModeloJTextField(produtoEletronico.getModelo());
            }
        }
    }
}
