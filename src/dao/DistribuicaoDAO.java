package dao;

import bean.Distribuicao;
import java.util.List;
import DB.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DistribuicaoDAO {

    private Connection conn;

    public void insert(Distribuicao s) {
        String sql = "INSERT INTO distribuicoes (kg, total_pago, clientes_id, data_entrega) VALUES (?, ?, ?, ?)";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, s.getKg());
            st.setInt(2, s.getTotalPago());
            st.setInt(3, s.getCliente().getId());
            st.setString(4, s.getDataEntrega());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
    }

    public void delete(Distribuicao s) {
        String sql = "DELETE FROM distribuicoes WHERE id = ?";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, s.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
    }

    public void update(Distribuicao s) {
        String sql = "UPDATE distribuicoes SET kg = ?, total_pago = ?, clientes_id, data_entrega = ? WHERE id = ?";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, s.getKg());
            st.setInt(2, s.getTotalPago());
            st.setInt(3, s.getCliente().getId());
            st.setString(4, s.getDataEntrega());
            st.setInt(4, s.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
    }

    public List<Distribuicao> findByDataEntrega(Distribuicao s) {
        String sql = "SELECT * FROM distribuicoes WHERE data_entrega = ?";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, s.getDataEntrega());
            return processResults(st.executeQuery());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public List<Distribuicao> findByKg(Distribuicao s) {
        String sql = "SELECT * FROM distribuicoes WHERE kg = ?";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, s.getKg());
            return processResults(st.executeQuery());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public List<Distribuicao> findAll() {
        String sql = "SELECT * FROM distribuicoes";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            return processResults(st.executeQuery());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    private List<Distribuicao> processResults(ResultSet rs) {
        List<Distribuicao> ls = new ArrayList<>();
        try {
            while (rs.next()) {
                ls.add(
                        new Distribuicao(
                                rs.getInt("id"),
                                rs.getInt("kg"),
                                rs.getInt("total_pago"),
                                rs.getInt("clientes_id"),
                                rs.getString("data_entrega")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DistribuicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQL Exception: " + ex.getMessage());
        }
        return ls;
    }
}
