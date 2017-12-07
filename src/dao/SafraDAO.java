package dao;

import bean.Safra;
import java.util.List;
import DB.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SafraDAO {

    private Connection conn;

    public void insert(Safra s) {
        String sql = "INSERT INTO safras (data_plantio, data_colheita, kg, tipo) VALUES (?, ?, ?, ?)";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, s.getDataPlantio());
            st.setString(2, s.getDataColheita());
            st.setInt(3, s.getKg());
            st.setString(4, s.getTipo());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
    }

    public void delete(Safra s) {
        String sql = "DELETE FROM safras WHERE id = ?";
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

    public void update(Safra s) {
        String sql = "UPDATE safras SET data_plantio = ?, data_colheita = ?, kg = ?, tipo = ? WHERE id = ?";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, s.getDataPlantio());
            st.setString(2, s.getDataColheita());
            st.setInt(3, s.getKg());
            st.setString(4, s.getTipo());
            st.setInt(4, s.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
    }

    public List<Safra> findByAno(Safra s) {
        String sql = "SELECT * FROM safras WHERE data_colheita = ?";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, s.getDataColheita());
            return processResults(st.executeQuery());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public List<Safra> findByTipo(Safra s) {
        String sql = "SELECT * FROM safras WHERE tipo = ?";
        conn = Conexao.getInstance();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, s.getTipo());
            return processResults(st.executeQuery());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public List<Safra> findAll() {
        String sql = "SELECT * FROM safras";
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

    private List<Safra> processResults(ResultSet rs) {
        List<Safra> ls = new ArrayList<>();
        try {
            while (rs.next()) {
                ls.add(
                        new Safra(
                                rs.getInt("id"),
                                rs.getString("data_plantio"),
                                rs.getString("data_colheita"),
                                rs.getInt("kg"),
                                rs.getString("tipo")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(SafraDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQL Exception: " + ex.getMessage());
        }
        return ls;
    }
}
