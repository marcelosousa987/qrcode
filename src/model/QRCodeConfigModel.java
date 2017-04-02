/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marcelo
 * 
 * Model responsável por guardar todas as configurações 
 * 
 */


public class QRCodeConfigModel {
    private String dbDriver = "com.mysql.jdbc.Driver";
    private String dbType = "mysql"; // ou microsoft:sqlserver, oracle, etc.
    private String dbName = "qrcode";
    private String sqlAddress = "localhost";
    private String sqlLogin = "root";
    private String sqlPass = "";
    private String arqDiretorio = "/";
    private boolean firstConfiguration = true; // Verificar se é a primeira vez que o usuário abre o programa

    public boolean isFirstConfiguration() {
        return firstConfiguration;
    }

    public void setFirstConfiguration(boolean firstConfiguration) {
        this.firstConfiguration = firstConfiguration;
    }

    public String getArqDiretorio() {
        return arqDiretorio;
    }

    public void setArqDiretorio(String arqDiretorio) {
        this.arqDiretorio = arqDiretorio;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getSqlAddress() {
        return sqlAddress;
    }

    public void setSqlAddress(String sqlAddress) {
        this.sqlAddress = sqlAddress;
    }

    public String getSqlLogin() {
        return sqlLogin;
    }

    public void setSqlLogin(String sqlLogin) {
        this.sqlLogin = sqlLogin;
    }

    public String getSqlPass() {
        return sqlPass;
    }

    public void setSqlPass(String sqlPass) {
        this.sqlPass = sqlPass;
    }
}
