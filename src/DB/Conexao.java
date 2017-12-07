package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String host = "localhost";
    private static final String user = "root";
    private static final String pass = "";
    private static final String port = "3306";
    private static final String dbnm = "aps_desktop";
    private static final String driver = "jdbc:mysql://";

    private static Connection con;

    public static Connection getInstance() {
        con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(driver + host + "/" + dbnm, user, pass);
        } catch (SQLException e) {
            System.err.println("Erro na conexão com a base de dados: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Classe não encontrada: " + ex.getMessage());
        }
        return con;
    }

}
