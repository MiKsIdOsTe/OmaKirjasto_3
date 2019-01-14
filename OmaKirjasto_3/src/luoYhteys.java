
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lentt
 */
public class luoYhteys {
 //Yhdistetään tietokantaan
        String url = "jdbc:derby://localhost:1527/omaTietokanta";
        String userName = "oma";
        String password = "oma";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        
    Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, userName, password);
        con.setAutoCommit(true);
        return con;
    }
    
    void putData(String sql) throws ClassNotFoundException, SQLException {
       Connection con = getConnection();
        Statement state = con.createStatement();
        state.executeUpdate(sql);
        state.close();
    }
    
    public Statement state;
    public ResultSet getData(String sql) throws ClassNotFoundException, SQLException {
        Connection con = getConnection();
        state = con.createStatement();
        ResultSet rset = state.executeQuery(sql);
        return rset;
    }
}