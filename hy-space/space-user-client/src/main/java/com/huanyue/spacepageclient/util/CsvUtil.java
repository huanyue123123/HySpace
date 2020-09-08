package com.huanyue.spacepageclient.util;

import java.io.*;

public class CsvUtil {

    public static String getJSONFromFile(String filePath, String separator) throws IOException {

        byte[] bytes = null;

        bytes = readFileByBytes(filePath);

        String csv = new String(bytes,"gbk");
        csv = csv.replaceAll("(\"|\n\")","");
//        System.out.println(csv);
        return getJSON(csv, separator).replace("\r", "").replace("\n", "").replace("\b", "").replaceAll("\\s*", "");
    }

    private static String getJSON(String content, String separator) {

        StringBuilder sb = new StringBuilder("[\n");

        String csv = content;
        String[] csvValues = csv.split("\n");
        String[] header = csvValues[0].split(separator);

        for (int i = 1; i < csvValues.length; i++) {
            sb.append("\t").append("{").append("\n");
            String[] tmp = csvValues[i].split(separator);

            for (int j = 0; j < tmp.length; j++) {

                sb.append("\t").append("\t\"").append(header[j].replaceAll("\\s*", "").replace("\"", "")).append("\":\"")
                        .append(tmp[j].replaceAll("\\s*", "").replace("\"", "")).append("\"");
                if (j < tmp.length - 1) {
                    sb.append(",\n");
                } else {
                    sb.append("\n");
                }
            }
            if (i < csvValues.length - 1) {
                sb.append("\t},\n");
            } else {
                sb.append("\t}\n");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    /**
     * 根据文件路径读取byte[] 数组
     */
    private static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }
                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }
                bos.close();
            }
        }
    }
}
