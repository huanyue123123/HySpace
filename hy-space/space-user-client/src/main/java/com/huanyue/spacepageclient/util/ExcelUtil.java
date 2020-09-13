package com.huanyue.spacepageclient.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelUtil {

    public static Map<String,List<Map<String,String>>> readExcel(String path){
        Map<String,List<Map<String,String>>> excelMap = new HashMap<>();

        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            wb = new XSSFWorkbook(fis);
            FormulaEvaluator evaluator =  new XSSFFormulaEvaluator((XSSFWorkbook) wb);
            int sheetNum = wb.getNumberOfSheets();
            for(int sheetIndex = 0;sheetIndex < sheetNum;sheetIndex++){
                List<Map<String,String>> maps = new LinkedList<>();
                Sheet sheet = wb.getSheetAt(sheetIndex);
                String sheetName = sheet.getSheetName();
                int rowNum = sheet.getLastRowNum();
                //获取表头
                Row title = sheet.getRow(0);
                int celNum = title.getLastCellNum();
                List<String> titleList = new ArrayList<>();
                for(int titleCellIndex = 0;titleCellIndex<=celNum;titleCellIndex++){
                    titleList.add(getCellValue(title.getCell(titleCellIndex),evaluator));
                }

                for(int rowIndex = 1;rowIndex<=rowNum;rowIndex++){
                    Row row = sheet.getRow(rowIndex);
                    Map<String,String> map = new HashMap<>();
                    for(int rowCellIndex = 0;rowCellIndex<=celNum;rowCellIndex++){

                        String value = getCellValue(row.getCell(rowCellIndex),evaluator);
                        map.put(titleList.get(rowCellIndex),value);
                    }
                    map.remove("");
                    maps.add(map);


                }
                excelMap.put(sheetName,maps);

            }

            fis.close();
        }catch (IOException e){
            e.printStackTrace();
            return excelMap;
        }
        return excelMap;
    }

    private static String getCellValue(Cell cell,FormulaEvaluator evaluator){
        String value = "";
        if (cell != null) {
            if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = null;
                    if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    } else {// 日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    }
                    value = sdf.format(cell.getDateCellValue());
                } else {
                    DecimalFormat df = new DecimalFormat("#.##");
                    value = df.format(cell.getNumericCellValue());
                }
            } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
                value = cell.getBooleanCellValue() + "";
            } else if (cell.getCellTypeEnum() == CellType.FORMULA) {
                CellValue cellValue = evaluator.evaluate(cell);
                if (cellValue.getCellTypeEnum() == CellType.NUMERIC) {
                    DecimalFormat df = new DecimalFormat("#.##");
                    value = df.format(cellValue.getNumberValue());
                } else {
                    value = cellValue.getStringValue();
                }
            } else if (cell.getCellTypeEnum() == CellType.BLANK) {
                value = "0";
            } else if (cell.getCellTypeEnum() == CellType.STRING) {
                value = cell.getStringCellValue();
            } else if (cell.getCellTypeEnum() == CellType._NONE) {
                value = "0";
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Map<String,List<Map<String,String>>> maps = readExcel("C:\\Users\\Administrator\\Desktop\\文档\\ZCFH_DATA.xlsx");
        List<Map<String,String>> ka = maps.get("KA");
        for(Map<String,String> mp:ka){
            String value = mp.get("jyxm_maxValue");
            String[]arr = value.split(";");
            for(String group:arr){
                System.out.println(group);
                if(group.contains("|")){
                    String[] h = group.split("\\|");
                    for(String hs:h){
                        System.out.println(hs);
                    }
                }
                if(group.contains("&")){
                    String[] q = group.split("&");
                    for(String qs:q){
                        System.out.println(qs);
                    }
                }



            }
        }


        System.out.println(maps.size());
    }
}
