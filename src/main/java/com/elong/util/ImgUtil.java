package com.elong.util;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

/**
 * 包名: com.hawkeye.util
 * 创建人 : Elong
 * 时间: 24/04/2017 1:35 PM
 * 描述 : 图片处理工具类
 */
public class ImgUtil {

    /**
     * 图片压缩
     */
    private static void doCompress(InputStream in, float quality, String dest) throws Exception {
        OutputStream os = null;
        ImageOutputStream ios = null;
        try {
            BufferedImage inImg = ImageIO.read(in);

            File destFile = new File(dest);
            destFile.createNewFile();
            os = new FileOutputStream(destFile, false);

            Iterator<ImageWriter> formats = ImageIO.getImageWritersByFormatName("jpg");
            ImageWriter writer = formats.next();

            ios = ImageIO.createImageOutputStream(os);
            writer.setOutput(ios);

            ImageWriteParam param = writer.getDefaultWriteParam();
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            // 图片质量
            param.setCompressionQuality(quality);
            writer.write(null, new IIOImage(inImg, null, null), param);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("exception throw when compress jpgs");
        } finally {
            if (os != null) {
                //noinspection ThrowFromFinallyBlock
                os.close();
            }
            if (ios != null) {
                ios.close();
            }
        }
    }

}
