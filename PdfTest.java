package com.sunyuki.ec.group.base.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by liuh on 2017/9/22 0022.
 *
 *    maven 依赖
 * 	  <dependency>
 *    <groupId>org.apache.pdfbox</groupId>
 *    <artifactId>pdfbox</artifactId>
 *    <version>2.0.7</ version>
 *    </dependency>
 *
 *
 *
 */
public class PdfTest {

    public static void main(String[] args) throws IOException {
        File file = new File("c:\\test.pdf");
        try {
            long y1 = System.currentTimeMillis();
            PDDocument doc = PDDocument.load(file);
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            for (int i = 0; i < pageCount; i++) {
                 BufferedImage image = renderer.renderImage(i, 0.5f);//缩放比例
                 ImageIO.write(image, "PNG", new File("C:\\pdfbox_image"+i+".png"));//生成多张图片
            }
            long y = System.currentTimeMillis();
            System.out.println(y-y1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
