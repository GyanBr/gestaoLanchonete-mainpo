package br.com.professorclaytonandrade.sistemaservicosjavafx.dao;

import br.com.professorclaytonandrade.sistemaservicosjavafx.model.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private Connection connection;

    public VendaDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Venda venda) throws SQLException {
        String sql = "INSERT INTO venda (produto, quantidade, valor_total, data) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, venda.getProduto());
            stmt.setInt(2, venda.getQuantidade());
            stmt.setDouble(3, venda.getValorTotal());
            stmt.setDate(4, Date.valueOf(venda.getData()));
            stmt.executeUpdate();
        }
    }

    public List<Venda> listarTodas() throws SQLException {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM venda";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Venda venda = new Venda(
                        rs.getInt("id"),
                        rs.getString("produto"),
                        rs.getInt("quantidade"),
                        rs.getDouble("valor_total"),
                        rs.getDate("data").toLocalDate()
                );
                vendas.add(venda);
            }
        }
        return vendas;
    }

    public void atualizar(Venda venda) throws SQLException {
        String sql = "UPDATE venda SET produto = ?, quantidade = ?, valor_total = ?, data = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, venda.getProduto());
            stmt.setInt(2, venda.getQuantidade());
            stmt.setDouble(3, venda.getValorTotal());
            stmt.setDate(4, Date.valueOf(venda.getData()));
            stmt.setInt(5, venda.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM venda WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
