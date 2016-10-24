/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;


public class ConFactory {
    public Connection getConnection() { // Retorna uma nova conexão para uma instância
        try {
             return DriverManager.getConnection("jdbc:mysql://localhost/qrcode", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
