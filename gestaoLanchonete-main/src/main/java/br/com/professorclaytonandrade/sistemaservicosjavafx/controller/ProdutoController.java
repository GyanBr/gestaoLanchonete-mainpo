package br.com.professorclaytonandrade.sistemaservicosjavafx.controller;

import br.com.professorclaytonandrade.sistemaservicosjavafx.model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.AlertType;

public class ProdutoController {

    @FXML
    private TextField descricaoField;

    @FXML
    private TextField precoField;

    @FXML
    private TextField quantidadeField;

    @FXML
    private TextField markupField;

    @FXML
    private TableView<Produto> produtosTable;

    @FXML
    private TableColumn<Produto, Integer> idColumn;

    @FXML
    private TableColumn<Produto, String> descricaoColumn;

    @FXML
    private TableColumn<Produto, Double> precoColumn;

    @FXML
    private TableColumn<Produto, Integer> quantidadeColumn;

    @FXML
    private TableColumn<Produto, Double> markupColumn;

    // Lista de produtos para a tabela
    private ObservableList<Produto> listaProdutos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurar colunas da tabela
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        descricaoColumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        precoColumn.setCellValueFactory(new PropertyValueFactory<>("preco"));
        quantidadeColumn.setCellValueFactory(new PropertyValueFactory<>("quantidadeEstoque"));
        markupColumn.setCellValueFactory(new PropertyValueFactory<>("markup"));

        // Definir a lista de produtos na tabela
        produtosTable.setItems(listaProdutos);
    }

    @FXML
    private void handleSalvar(ActionEvent event) {
        // Validar campos
        if (!validarCampos()) {
            return;
        }

        try {
            // Criar novo produto
            Produto novoProduto = new Produto(
                    descricaoField.getText().trim(),
                    Double.parseDouble(precoField.getText().trim()),
                    Integer.parseInt(quantidadeField.getText().trim()),
                    Double.parseDouble(markupField.getText().trim())
            );

            // Adicionar à lista (em um cenário real, você salvaria no banco de dados)
            listaProdutos.add(novoProduto);

            // Limpar campos após salvar
            handleLimpar(event);

            // Mostrar mensagem de sucesso
            mostrarAlerta(AlertType.INFORMATION, "Sucesso", "Produto salvo com sucesso!");
        } catch (NumberFormatException e) {
            mostrarAlerta(AlertType.ERROR, "Erro de Formato",
                    "Por favor, insira valores numéricos válidos para Preço, Quantidade e Markup.");
        }
    }

    // Método de validação dos campos
    private boolean validarCampos() {
        // Verificar se descrição não está vazia
        if (descricaoField.getText().trim().isEmpty()) {
            mostrarAlerta(AlertType.WARNING, "Validação", "Por favor, insira uma descrição.");
            descricaoField.requestFocus();
            return false;
        }

        // Verificar campos numéricos
        try {
            double preco = Double.parseDouble(precoField.getText().trim());
            int quantidade = Integer.parseInt(quantidadeField.getText().trim());
            double markup = Double.parseDouble(markupField.getText().trim());

            // Validações adicionais de valores
            if (preco < 0) {
                mostrarAlerta(AlertType.WARNING, "Validação", "Preço não pode ser negativo.");
                precoField.requestFocus();
                return false;
            }

            if (quantidade < 0) {
                mostrarAlerta(AlertType.WARNING, "Validação", "Quantidade não pode ser negativa.");
                quantidadeField.requestFocus();
                return false;
            }

            if (markup < 0) {
                mostrarAlerta(AlertType.WARNING, "Validação", "Markup não pode ser negativo.");
                markupField.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta(AlertType.WARNING, "Validação",
                    "Por favor, insira valores numéricos válidos para Preço, Quantidade e Markup.");
            return false;
        }

        return true;
    }

    @FXML
    private void handleLimpar(ActionEvent event) {
        descricaoField.clear();
        precoField.clear();
        quantidadeField.clear();
        markupField.clear();
    }

    @FXML
    private void handleExcluir(ActionEvent event) {
        Produto produtoSelecionado = produtosTable.getSelectionModel().getSelectedItem();

        if (produtoSelecionado == null) {
            mostrarAlerta(AlertType.WARNING, "Exclusão", "Selecione um produto para excluir.");
            return;
        }

        // Remover da lista (em um cenário real, você removeria do banco de dados)
        listaProdutos.remove(produtoSelecionado);

        // Limpar seleção
        produtosTable.getSelectionModel().clearSelection();
    }

    // Método auxiliar para mostrar alertas
    private void mostrarAlerta(AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}