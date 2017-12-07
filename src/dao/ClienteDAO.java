package dao;

import bean.Cliente;
import java.util.List;
import DB.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    private Connection conn;

    public void insert(Cliente s) {
        String sql = "INSERT INTO clientes (nome, cidade) VALUES (?, ?)";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, s.getNome());
            st.setString(2, s.getCidade());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
    }

    public void delete(Cliente s) {
        String sql = "DELETE FROM clientes WHERE id = ?";
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

    public void update(Cliente s) {
        String sql = "UPDATE clientes SET nome = ?, cidade = ? WHERE id = ?";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, s.getNome());
            st.setString(2, s.getCidade());
            st.setInt(3, s.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
    }

    public List<Cliente> findByCidade(Cliente s) {
        String sql = "SELECT * FROM clientes WHERE cidade LIKE ?";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + s.getCidade() + "%");
            return processResults(st.executeQuery());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public List<Cliente> findByNome(Cliente s) {
        String sql = "SELECT * FROM clientes WHERE nome LIKE";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + s.getNome() + "%");
            return processResults(st.executeQuery());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public List<Cliente> findAll() {
        String sql = "SELECT * FROM clientes";
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
    
    public Cliente find(int id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            return processResults(st.executeQuery()).get(0);
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    private List<Cliente> processResults(ResultSet rs) {
        List<Cliente> ls = new ArrayList<>();
        try {
            while (rs.next()) {
                ls.add(
                        new Cliente(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("cidade")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQL Exception: " + ex.getMessage());
        }
        return ls;
    }
}
