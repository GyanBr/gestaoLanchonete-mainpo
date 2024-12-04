package br.com.professorclaytonandrade.sistemaservicosjavafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class DespesaController {

    @FXML
    private Label tituloLabel;

    @FXML
    private Label descricaoLabel;

    @FXML
    private Label valorLabel;

    @FXML
    private Label dataLabel;

    @FXML
    private TextArea descricaoTextArea;

    @FXML
    private TextField valorTextField;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private Button limparButton;

    @FXML
    private Button salvarButton;

    @FXML
    private TableView<?> despesasTableView;

    @FXML
    private TableColumn<?, ?> dataColumn;

    @FXML
    private TableColumn<?, ?> descricaoColumn;

    @FXML
    private TableColumn<?, ?> valorColumn;

    @FXML
    public void initialize() {
        // Código de inicialização, como vinculação de colunas da tabela se necessário
    }

    @FXML
    private void handleSalvar(ActionEvent event) {
        // Lógica para salvar a despesa
        // Exemplo: validar entrada, criar um novo objeto Despesa e salvar em um banco de dados ou lista
    }

    @FXML
    private void handleLimpar(ActionEvent event) {
        // Lógica para limpar os campos de entrada
        descricaoTextArea.clear();
        valorTextField.clear();
        dataPicker.setValue(null);
    }
}
