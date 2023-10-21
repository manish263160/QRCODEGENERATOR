package org.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the QR code generator for any kind of String
 * @author MANISH KM
 */
public class GenerateQRCode {

    public static void main(String[] args) {
        // Replace 'https://www.youtube.com/@mmjvibes' with the URL you want to encode
        String url = "https://www.youtube.com/@mmjvibes";

        // Specify the file path to save the QR code
        String filePath = "D:\\qr_code.png";

        // Set QR code properties
        int width = 2334; // Width of the QR code
        int height = 2314; // Height of the QR code
        String format = "PNG"; // Image format

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        try {
            //From here these are com.google.zxing dependency will be used
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToPath(bitMatrix, format, new File(filePath).toPath());
            System.out.println("QR code generated and saved at: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
