/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.QRCodeConfigModel;
import model.QRCodeModel;

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
    private int counter = 0;

    public int getCounter() {
        return counter;
    }
    
    public FileIOController(String filename){
        this.filename = filename;
    }
    
    public JTable carregarListaDeArquivos(JTable listaDeArquivos, QRCodeConfigModel QRCodeConfig,
            QRCodeModel qrc, QRCodeEditController qrcm){
        
        File fileList = new File(QRCodeConfig.getArqDiretorio());
        
        HashMap<String,String> hashFileList;
        /* Utilizaremos HashMap para melhor organizar o nome dos arquivos 
         * e atribuir o código decodificado de cada imagem exibida 
         */
        hashFileList = new HashMap<>();

        File[] files = fileList.listFiles();

        DefaultTableModel model = (DefaultTableModel)listaDeArquivos.getModel();

        System.out.println("Diretório: " + QRCodeConfig.getArqDiretorio());
        
                
        for(int i = 0; i < files.length; i++){
            if(files[i].getName().matches("^.*\\.(png|jpg|gif)$"))
            {
                qrc.setFileName(files[i].getAbsolutePath());
                qrcm.decodificarQRCode(qrc);
                if(qrc.getQRCodeText() != null){
                    hashFileList.put(files[i].getName(), qrc.getQRCodeText());
                    counter++;
                    qrc.setQRCodeText(null); 
                }
            }
        }
        
        for(Map.Entry m : hashFileList.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
            model.addRow(new Object[] {m.getKey(), m.getValue()});
        }
        
        return listaDeArquivos;
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
