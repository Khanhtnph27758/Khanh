/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natsu
 */
public class DBContext {
    private static String user = "sa";
    private static String pass = "1111";
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=handDuAn1;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
    
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getConnection(){
        Connection cn = null;
        
        try {
            cn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }
    public static void main(String[] args) {
        Connection cn = getConnection();
        if(cn!=null){
            System.out.println("Ket noi thanh cong");
        }
        else{
            System.out.println("Ket noi that bai");
        }
    }
}
