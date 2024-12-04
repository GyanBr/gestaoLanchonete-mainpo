package br.com.professorclaytonandrade.sistemaservicosjavafx.model;

import java.time.LocalDate;

public class Venda {
    private int id;
    private String produto;
    private int quantidade;
    private double valorTotal;
    private LocalDate data;

    public Venda(int id, String produto, int quantidade, double valorTotal, LocalDate data) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.data = data;
    }

    public Venda(String produto, int quantidade, double valorTotal, LocalDate data) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.data = data;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProduto() { return produto; }
    public void setProduto(String produto) { this.produto = produto; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
}
