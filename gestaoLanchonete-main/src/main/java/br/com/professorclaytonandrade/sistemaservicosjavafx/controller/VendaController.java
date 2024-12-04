package br.com.professorclaytonandrade.sistemaservicosjavafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class VendaController {

    @FXML
    private Label tituloLabel;

    @FXML
    private Label dataLabel;

    @FXML
    private Label produtoLabel;

    @FXML
    private Label quantidadeLabel;

    @FXML
    private Label precoTotalLabel;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private ComboBox<String> produtoComboBox;

    @FXML
    private TextField quantidadeTextField;

    @FXML
    private TextField precoTotalTextField;

    @FXML
    private Button limparButton;

    @FXML
    private Button salvarButton;

    @FXML
    public void initialize() {
        // Código de inicialização, como preencher o ComboBox com os produtos disponíveis
        produtoComboBox.getItems().addAll("Produto 1", "Produto 2", "Produto 3"); // Exemplo de produtos
    }

    @FXML
    private void handleSalvar(ActionEvent event) {
        // Lógica para salvar a venda
        // Exemplo: validar entrada, calcular o total, criar um novo objeto de venda e salvar em um banco de dados ou lista
    }

    @FXML
    private void handleLimpar(ActionEvent event) {
        // Lógica para limpar os campos de entrada
        dataPicker.setValue(null);
        produtoComboBox.getSelectionModel().clearSelection();
        quantidadeTextField.clear();
        precoTotalTextField.clear();
    }
}
