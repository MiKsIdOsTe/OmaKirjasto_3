package OmaMgpackage;


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
public class JCDB {
 //Yhdistetään tietokantaan
        String url = "jdbc:derby://localhost:1527/OmaKirjasto2";
        String userName = "oma";
        String password = "oma";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        
    Connection getConnection() throws ClassNotFoundException, SQLException {
        System.out.println("1");
        Class.forName(driver);
        System.out.println("2");
        Connection con = DriverManager.getConnection(url, userName, password);
        System.out.println("3");
        con.setAutoCommit(true);
        System.out.println("4");
        return con;
    }
    
    void putData(String sql) throws ClassNotFoundException, SQLException {
        System.out.println("5");
       Connection con = getConnection();
       System.out.println("6");
        Statement state = con.createStatement();
        System.out.println("7");
        state.executeUpdate(sql);
        System.out.println("8");
        state.close();
        System.out.println("9");
    }
    
    public Statement state;
    public ResultSet getData(String sql) throws ClassNotFoundException, SQLException {
        System.out.println("10");
        Connection con = getConnection();
        System.out.println("11");
        state = con.createStatement();
        System.out.println("12");
        ResultSet rset = state.executeQuery(sql);
        System.out.println("13");
        return rset;
    }
}