/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;


public class ConFactory {
    
    /* Essas configurações serão exportadas em um arquivo binário futuramente */
    
    private final String dbDriver = "com.mysql.jdbc.Driver";
    private final String dbType = "mysql"; // ou microsoft:sqlserver, oracle, etc.
    private final String dbName = "qrcode";
    private final String sqlAddress = "localhost";
    private final String sqlLogin = "root";
    private final String sqlPass = "";
    
    /*               */
    
    public Connection getConnection() { // Retorna uma nova conexão para uma instância
        
        try {
             Class.forName(dbDriver);            // Registrar driver 
             return DriverManager.getConnection("jdbc:" + dbType + "://" + sqlAddress + "/" + dbName, sqlLogin, sqlPass);
        } catch (SQLException | ClassNotFoundException e) { // Catch SQL excep ou erro no driver
            throw new RuntimeException(e);
        }
    }
}
