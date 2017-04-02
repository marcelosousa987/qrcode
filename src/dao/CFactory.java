/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import model.QRCodeConfigModel;


public class CFactory{
    
    /* Essas configurações serão exportadas em um arquivo binário futuramente */
    /*               */
    
    public Connection getConnection(QRCodeConfigModel QRCodeConfig) { // Retorna uma nova conexão para uma instância
        
        try {
             Class.forName(QRCodeConfig.getDbDriver());            // Registrar driver 
             return DriverManager.getConnection("jdbc:" + QRCodeConfig.getDbType() + "://" 
                     + QRCodeConfig.getSqlAddress() + "/" 
                     + QRCodeConfig.getDbName(), QRCodeConfig.getSqlLogin(), QRCodeConfig.getSqlPass());
        } catch (SQLException | ClassNotFoundException e) { // Catch SQL excep ou erro no driver
            throw new RuntimeException(e);
        }
    }
}
