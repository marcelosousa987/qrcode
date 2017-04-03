/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.QRCodeModel;

/**
 *
 * Responsável por criar, ler e atualizar o Banco de Dados
 * Irá utilizar o model QRCodeModel como entrada de dados
 * TABLE TESTEQR
 +-----------+-------------+------+-----+---------+----------------+
 | Field     | Type        | Null | Key | Default | Extra          |
 +-----------+-------------+------+-----+---------+----------------+
 | id        | int(10)     | NO   | PRI | NULL    | auto_increment |
 | filename  | varchar(20) | NO   |     | NULL    |                |
 | qrcodetxt | varchar(20) | YES  |     | NULL    |                |
 +-----------+-------------+------+-----+---------+----------------+
 */
public class ConnectionController {
    private final String sqlStatement = "insert into testeqr" +
                                        "(filename, qrcodetxt)" +
                                        " values (?, ?)";
    
    private final String sqlTable = "create table if not exists testeqr" +
                                    "(id int(10) PRIMARY KEY AUTO_INCREMENT, "+
                                    "filename varchar(20) NOT NULL,"+
                                    "qrcodetxt varchar(20))";
    
    private PreparedStatement pStmt;
    
    public void InserirInformacoes(Connection con, QRCodeModel qrcm) throws SQLException {
        pStmt = con.prepareStatement(sqlStatement);
        pStmt.setString(1, qrcm.getFileName()); // Salva nome do arquivo do Model
        pStmt.setString(2, qrcm.getQRCodeText()); // Salva conteúdo do QR Code do Model
        // pStmt.setBlob(0, x); // Aqui será inputado o arquivo do QRCode em formato BLOB
        pStmt.execute();
        pStmt.close();
    }
    
    public void GerarTabela(Connection con) throws SQLException{
        pStmt = con.prepareStatement(sqlTable);
        pStmt.execute(sqlTable);
        pStmt.close();
    }
}
