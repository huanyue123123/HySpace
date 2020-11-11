package com.huanyue.spacepageclient.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
@Slf4j
public class PdfUtil {



    public static String getPdfInfo(String path){
        StringBuffer info = new StringBuffer();
        try {
            File pdf = new File(path);
            PDDocument doc = PDDocument.load(pdf);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(doc);
            info.append(text);
            log.info(text);
            log.info(text.replaceAll("[\\s\\p{Zs}]+",""));

        }catch (Exception e){
            return "";
        }



        return info.toString();
    }

}
