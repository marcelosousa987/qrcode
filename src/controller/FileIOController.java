/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.QRCodeConfigModel;

/**
 *
 * @author Marcelo
 * 
 * Controller responsável por criar o arquivo de configurações e carregar 
 * 
 */
public final class FileIOController{
    private final String filename;
    private FileInputStream arquivoLeitura;
    private ObjectInputStream objLeitura;
    private FileOutputStream arquivoGravar;
    private ObjectOutputStream objGravar;
    
    public FileIOController(String filename){
        this.filename = filename;
    }
    
    public QRCodeConfigModel carregarConfiguracoes(QRCodeConfigModel QRConfig) throws Exception{
       
            arquivoLeitura = new FileInputStream(filename);
            objLeitura     = new ObjectInputStream(arquivoLeitura);
            
            QRConfig = (QRCodeConfigModel) objLeitura.readObject(); // Ler o objeto e transformar do tipo QRCodeConfigModel
            
            objLeitura.close();
            arquivoLeitura.close();
            
            return QRConfig; // Retornar o objeto
    }
    
    public void escreverConfiguracoes(QRCodeConfigModel QRConfig) throws Exception{
            arquivoGravar = new FileOutputStream(filename);
            objGravar = new ObjectOutputStream(arquivoGravar);
            
            objGravar.writeObject(QRConfig);
            objGravar.flush();
            objGravar.close();
            
            arquivoGravar.flush();
            arquivoGravar.close();
    }
}
