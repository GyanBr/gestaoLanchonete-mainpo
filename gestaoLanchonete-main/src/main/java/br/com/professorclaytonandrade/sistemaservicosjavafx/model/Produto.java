package br.com.professorclaytonandrade.sistemaservicosjavafx.model;

import javafx.beans.property.*;

public class Produto {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty descricao = new SimpleStringProperty();
    private final DoubleProperty preco = new SimpleDoubleProperty();
    private final IntegerProperty quantidadeEstoque = new SimpleIntegerProperty();
    private final DoubleProperty markup = new SimpleDoubleProperty();

    // Construtores
    public Produto() {}

    public Produto(String descricao, double preco, int quantidadeEstoque, double markup) {
        setDescricao(descricao);
        setPreco(preco);
        setQuantidadeEstoque(quantidadeEstoque);
        setMarkup(markup);
    }

    public Produto(int id, String descricao, double preco, int quantidadeEstoque, double markup) {
        setId(id);
        setDescricao(descricao);
        setPreco(preco);
        setQuantidadeEstoque(quantidadeEstoque);
        setMarkup(markup);
    }

    // Getters e Setters
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public double getPreco() {
        return preco.get();
    }

    public void setPreco(double preco) {
        this.preco.set(preco);
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque.get();
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque.set(quantidadeEstoque);
    }

    public double getMarkup() {
        return markup.get();
    }

    public void setMarkup(double markup) {
        this.markup.set(markup);
    }

    // Métodos Property para binding
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public DoubleProperty precoProperty() {
        return preco;
    }

    public IntegerProperty quantidadeEstoqueProperty() {
        return quantidadeEstoque;
    }

    public DoubleProperty markupProperty() {
        return markup;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + getId() +
                ", descricao='" + getDescricao() + '\'' +
                ", preco=" + getPreco() +
                ", quantidadeEstoque=" + getQuantidadeEstoque() +
                ", markup=" + getMarkup() +
                '}';
    }
}