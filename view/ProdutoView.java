package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProdutoView extends JFrame {

    private JLabel tipoProdutoJLabel;
    private JComboBox<String> tipoProdutoJComboBox;

    private JLabel nomeJLabel;
    private JTextField nomeJTextField;

    private JLabel precoJLabel;
    private JTextField precoJTextField;

    private JLabel quantJLabel;
    private JTextField quantJTextField;

    private JLabel marcaJLabel;
    private JTextField marcaJTextField;

    private JLabel modeloJLabel;
    private JTextField modeloJTextField;

    private JLabel dataValidadeJLabel;
    private JTextField dataValidadeJTextField;

    private JButton adicionarJButton;
    private JButton removerJButton;
    private JButton editarJButton;
    private JButton listarOrdemJButton;
    private JButton listarNaoOrdemJButton;
    private JButton pesquisarJButton;

    private JTextArea listaProdutosJTextArea;

    public ProdutoView() {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        tipoProdutoJLabel = new JLabel("Tipo de Produto:");
        String[] opcoes = {"Alimento", "Eletrônico"};
        tipoProdutoJComboBox = new JComboBox<>(opcoes);

        nomeJLabel = new JLabel("Nome:");
        nomeJTextField = new JTextField(20);

        precoJLabel = new JLabel("Preço:");
        precoJTextField = new JTextField(20);

        quantJLabel = new JLabel("Quantidade:");
        quantJTextField = new JTextField(20);

        marcaJLabel = new JLabel("Marca:");
        marcaJTextField = new JTextField(20);

        modeloJLabel = new JLabel("Modelo:");
        modeloJTextField = new JTextField(20);

        dataValidadeJLabel = new JLabel("Data de Validade (para alimentos):");
        dataValidadeJTextField = new JTextField(20);

        adicionarJButton = new JButton("Adicionar Produto");
        removerJButton = new JButton("Remover Produto");
        editarJButton = new JButton("Editar Produto");
        listarOrdemJButton = new JButton("Listar Produtos Ordenados");
        listarNaoOrdemJButton = new JButton("Listar Produtos Não Ordenados");
        pesquisarJButton = new JButton("Pesquisar");

        listaProdutosJTextArea = new JTextArea(10, 60);

        // Adicionando componentes usando GridBagConstraints

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tipo de Produto
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(tipoProdutoJLabel, gbc);
        
        gbc.gridx = 1;
        add(tipoProdutoJComboBox, gbc);

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nomeJLabel, gbc);

        gbc.gridx = 1;
        add(nomeJTextField, gbc);

        // Preço
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(precoJLabel, gbc);

        gbc.gridx = 1;
        add(precoJTextField, gbc);

        // Quantidade
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(quantJLabel, gbc);

        gbc.gridx = 1;
        add(quantJTextField, gbc);

        // Marca
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(marcaJLabel, gbc);

        gbc.gridx = 1;
        add(marcaJTextField, gbc);

        // Modelo
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(modeloJLabel, gbc);

        gbc.gridx = 1;
        add(modeloJTextField, gbc);

        // Data de Validade
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(dataValidadeJLabel, gbc);

        gbc.gridx = 1;
        add(dataValidadeJTextField, gbc);

        // Botões
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(adicionarJButton, gbc);

        gbc.gridx = 1;
        add(removerJButton, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        add(editarJButton, gbc);

        gbc.gridx = 1;
        add(listarOrdemJButton, gbc);

        gbc.gridy = 9;
        gbc.gridx = 0;
        add(listarNaoOrdemJButton, gbc);

        gbc.gridy = 9;
        gbc.gridx = 1;
        add(pesquisarJButton, gbc);

        // Area de texto
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(listaProdutosJTextArea, gbc);

        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JComboBox getTipoProdutoJComboBox () {
        return tipoProdutoJComboBox;
    }

    public JTextField getNomeJTextField () {
        return nomeJTextField;
    }

    public void setNomeJTextField (String nome) {
        this.nomeJTextField.setText(nome);
    }

    public JTextField getPrecoJTextField () {
        return precoJTextField;
    }

    public void setPrecoJTextField (Double preco) {
        this.precoJTextField.setText(preco.toString());
    }

    public JTextField getQuantJTextField () {
        return quantJTextField;
    }

    public void setQuantJTextField (int quantidade) {
        this.quantJTextField.setText(Integer.toString(quantidade));
    }

    public JTextField getMarcaJTextField () {
        return marcaJTextField;
    }

    public void setMarcaJTextField (String marca) {
        this.marcaJTextField.setText(marca);
    }

    public JTextField getModeloJTextField () {
        return modeloJTextField;
    }

    public void setModeloJTextField (String modelo) {
        this.modeloJTextField.setText(modelo);
    }

    public JTextField getDataValidadeJTextField () {
        return dataValidadeJTextField;
    }

    public void setDataValidadeJTextField (String dataValidade) {
        this.dataValidadeJTextField.setText(dataValidade);
    }

    public JButton getAdicionarJButton () {
        return adicionarJButton;
    }

    public JButton getRemoverJButton () {
        return removerJButton;
    }

    public JButton getEditarJButton () {
        return editarJButton;
    }

    public JButton getListarOrdemJButton () {
        return listarOrdemJButton;
    }

    public JButton getListarNaoOrdemJButton () {
        return listarNaoOrdemJButton;
    }

    public JButton getPesquisarJButton () {
        return pesquisarJButton;
    }

    public JTextArea getListaProdutosJTextArea () {
        return listaProdutosJTextArea;
    }

}
