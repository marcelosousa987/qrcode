/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.awt.image.BufferedImage;


/**
 *
 * @author Marcelo, Joao e Everaldo
 */
public class QRCodeModel {
    private String fileName;
    private String qrCodeText;
    private int imageWidth;
    private int imageHeight;
    private BufferedImage image;
    
    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageSize(int imageWidth, int imageHeight) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }


    public QRCodeModel() {
        this.image = null;
    }
    
    public void setImage(BufferedImage image){
        this.image = image;
    }
    
    public Image getImage(){
        return image;
    }
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getQRCodeText() {
        return qrCodeText;
    }

    public void setQRCodeText(String qrCodeText) {
        this.qrCodeText = qrCodeText;
    }
}
