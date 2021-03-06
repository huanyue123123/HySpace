package com.huanyue.spacepageclient.util;

import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
public class ImageUtil {

    public static String getTextFromImg(String path) {
        ITesseract instance = new Tesseract();
        //如果未将tessdata放在根目录下需要指定绝对路径
        //instance.setDatapath("the absolute path of tessdata");

        //如果需要识别英文之外的语种，需要指定识别语种，并且需要将对应的语言包放进项目中
        instance.setLanguage("chi_sim");
        instance.setDatapath("E:\\workspace\\HySpace\\hy-space\\space-user-client\\src\\main\\resources\\tessdata");
        // 指定识别图片
        File imgDir = new File(path);
        long startTime = System.currentTimeMillis();
        String ocrResult = null;
        try {
            ocrResult = instance.doOCR(imgDir);
        } catch (TesseractException e) {
            log.error("error");
        }

        // 输出识别结果
        System.out.println("OCR Result: \n" + ocrResult + "\n 耗时：" + (System.currentTimeMillis() - startTime) + "ms");
        return ocrResult;
    }


}
