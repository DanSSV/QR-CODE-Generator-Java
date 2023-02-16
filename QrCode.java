/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class QrCode {
    private static final String outputQr= "D:\\outputqrcode.jpg";

    private static void generateQrcode(String text, int width, int height, String filePath) throws WriterException{
        QRCodeWriter qrc = new QRCodeWriter();
        BitMatrix bm = qrc.encode(text,BarcodeFormat.QR_CODE,width, height);
        Path pobj = FileSystems.getDefault().getPath(filePath);
        
        try {
            MatrixToImageWriter.writeToPath(bm, "PNG", pobj);
        } catch (IOException ex) {
            Logger.getLogger(QrCode.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void main(String[] args) throws WriterException{
        generateQrcode("https://www.facebook.com/apriljoy.hachero", 1250, 1250, outputQr);
       
    }

   
}
