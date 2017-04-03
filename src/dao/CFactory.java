/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
/*
*
*
* DAO responsável por gerar uma nova conexão
*
*
*/
import java.sql.*;
import javax.swing.JOptionPane;
import model.QRCodeConfigModel;


public class CFactory{
    
    public Connection getConnection(QRCodeConfigModel QRCodeConfig) { // Retorna uma nova conexão para uma instância
        
        try {
             Class.forName(QRCodeConfig.getDbDriver());            // Registrar driver 
             return DriverManager.getConnection("jdbc:" + QRCodeConfig.getDbType() + "://" 
                     + QRCodeConfig.getSqlAddress() + "/" 
                     + QRCodeConfig.getDbName(), QRCodeConfig.getSqlLogin(), QRCodeConfig.getSqlPass());
        } catch (SQLException | ClassNotFoundException e) { // Catch SQL excep ou erro no driver
            JOptionPane.showMessageDialog(null, "Erro durante o teste de conexão. \n" +
                    e.getMessage(),
                    "Teste de conexão", 
                    JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }
}
