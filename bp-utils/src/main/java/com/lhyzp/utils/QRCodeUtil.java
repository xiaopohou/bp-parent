package com.lhyzp.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 二维码、条码生成与解析
 * Created by Administrator on 2017-12-15.
 */
public class QRCodeUtil {


    /**
     * 生成二维码
     * @param filePath
     * @param content
     * @param width
     * @param height
     */
    public static void encodeQRCode(String filePath,String content,int width,int height) throws WriterException, IOException {
        Map<EncodeHintType, Object> hints = new HashMap();
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix,"png",path);
    }

    /**
     * 生成二维码
     * @param stream
     * @param content
     * @param width
     * @param height
     */
    public static void encodeQRCode(OutputStream stream, String content, int width, int height) throws WriterException, IOException {
        Map<EncodeHintType, Object> hints = new HashMap();
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        //边距,默认是4
        hints.put(EncodeHintType.MARGIN,0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        MatrixToImageWriter.writeToStream(bitMatrix,"png",stream);
    }

    /**
     * 解析二维码\条形码
     * @param filePath
     * @throws IOException
     * @throws NotFoundException
     */
    public static String decodeQRCode(String filePath) throws IOException, NotFoundException {
        BufferedImage image = ImageIO.read(new File(filePath));
        BufferedImageLuminanceSource bufferedImageLuminanceSource = new BufferedImageLuminanceSource(image);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(bufferedImageLuminanceSource));
        Map<DecodeHintType, Object> hints = new Hashtable<>();
        hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
        Result result = new MultiFormatReader().decode(binaryBitmap, hints);
        return result.getText();
    }

    /**
     * 生成条形码
     * @param stream
     * @param content
     * @param width
     * @param height
     */
    public static void encodeBarCode(OutputStream stream, String content, int width, int height) throws WriterException, IOException {
        Map<EncodeHintType, Object> hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.CODE_128, width, height, hints);
        MatrixToImageWriter.writeToStream(bitMatrix,"png",stream);
    }

}
