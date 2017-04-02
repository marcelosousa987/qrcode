/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.QRCodeConfigModel;

/**
 *
 * @author Marcelo
 * 
 * Controller responsável por criar o arquivo de configurações e carregar 
 * 
 */
public final class FileIOController{
    PrintWriter pw; // Escrever o arquivo
    BufferedReader br; // Ler o arquivo
    private final ArrayList<String> fileConfig; // Arraylist para manusear as informações
    private final String filename;
    
    public FileIOController(String filename, QRCodeConfigModel QRConfig){
        fileConfig = new ArrayList<String>();
        this.filename = filename;

    }
    
    public boolean carregarConfiguracoes(QRCodeConfigModel QRConfig){
        try {
            br = new BufferedReader(new FileReader(filename));
            System.out.println("Carregando...");
            String lerLinha = null;
            while((lerLinha = br.readLine()) != null)
                fileConfig.add(lerLinha);
            
            br.close();
            
            QRConfig.setArqDiretorio(fileConfig.get(0));
            QRConfig.setDbName(fileConfig.get(1));
            QRConfig.setDbType(fileConfig.get(2));
            QRConfig.setSqlAddress(fileConfig.get(3));
            QRConfig.setSqlLogin(fileConfig.get(4));
            QRConfig.setSqlPass(fileConfig.get(5));
            QRConfig.setFirstConfiguration(Boolean.valueOf(fileConfig.get(6)));
            
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public boolean escreverConfiguracoes(QRCodeConfigModel QRConfig){
           
            fileConfig.clear(); 
            fileConfig.add(QRConfig.getArqDiretorio());
            fileConfig.add(QRConfig.getDbName());
            fileConfig.add(QRConfig.getDbType());
            fileConfig.add(QRConfig.getSqlAddress());
            fileConfig.add(QRConfig.getSqlLogin());
            fileConfig.add(QRConfig.getSqlPass());
            fileConfig.add(String.valueOf(QRConfig.isFirstConfiguration())); // Boolean > String
            
        try {
            pw = new PrintWriter(new FileOutputStream(filename));
            
            for(String config : fileConfig)
                pw.println(config);
            pw.close();
            fileConfig.clear();
            return true;
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
