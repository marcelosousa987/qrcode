/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.QRCodeModel;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author Marcelo, João e Everaldo
 */
public class QRCodeEditController {

    public boolean gerarQRCode(QRCodeModel qrc) {
        try (
                FileOutputStream f = new FileOutputStream(qrc.getFileName()); // carregar stream
                ByteArrayOutputStream out = QRCode.from(qrc.getQRCodeText()) // array do formato do QRCode
                .to(ImageType.PNG)
                .withSize(qrc.getImageWidth(), qrc.getImageHeight())
                .stream();) {
            f.write(out.toByteArray());
            f.flush();
            f.close();
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());;
            return false;
        }
    }

    public boolean decodificarQRCode(QRCodeModel qrc) {
        try {
            BinaryBitmap bitmap = new BinaryBitmap(
                    new HybridBinarizer(
                            new BufferedImageLuminanceSource(
                                    ImageIO.read(new FileInputStream(qrc.getFileName())))));
            Result decQRCode = new MultiFormatReader().decode(bitmap);
            qrc.setQRCodeText(decQRCode.getText());
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean exibirQRCode(QRCodeModel qrc) { //função para atribuir o QRCode ao model
        try {
            File sourceimage = new File(qrc.getFileName());
            qrc.setImage(ImageIO.read(sourceimage));
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
