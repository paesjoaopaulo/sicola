package DB;

import bean.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    private final String host;
    private final String user;
    private final String pass;
    private final String port;
    private final String dbnm;
    private final String driver;

    private Connection con;

    public Conexao() {
        this.host = "localhost";
        this.user = "root";
        this.pass = "123";
        this.port = "3306";
        this.dbnm = "lara";
        this.driver = "jdbc:mysql://";
    }

    public void getInstance() {
        this.con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection(driver + host + "/" + dbnm, user, pass);
            PreparedStatement st = this.con.prepareStatement("SELECT * FROM usuarios");
            ResultSet res = st.executeQuery();
            while(res.next()){
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
