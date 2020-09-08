import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class TypeCode {

    public final static Map<String,String> map = new HashMap<>();

    static {
        map.put("1","A");
        map.put("2","B");
        map.put("4","C");
        map.put("5","D");
        map.put("6","E");
        map.put("7","F");
        map.put("15","G");
        map.put("12","L");
        map.put("13","M");
        map.put("3","O");
        map.put("14","T");
        map.put("1(M1)","V");
        map.put("8","W");
        map.put("9","Y");
        map.put("10","X");
        map.put("11","Z");
        map.put("16","5");
        map.put("17","6");


    }

    public static void main(String [] args) throws UnsupportedEncodingException {
        String s = "12/13/16/17";
        System.out.println(getCode(s));
        String s1 = "艰苦户籍科撒";
        String iso = new String(s1.getBytes("UTF-8"),"ISO-8859-1");
        String res = new String(iso.getBytes("ISO-8859-1"),"utf-8");
        System.out.println(iso);
        System.out.println(res);

        String s13 = "SELECT\n" +
                "\ta.cp_id,\n" +
                "\ta.FILEITEM,\n" +
                "\ta.FILENAME,\n" +
                "b.qy_id,\t"+
                "\t'/3310a/lxsoft/cpsb/workbase/cpsbserver/upload/qy_data/Y2006M8/' || b.qy_id || '/gzkz/' || a.filename AS path \n" +
                "FROM\n" +
                "\tggbak.FBCX_FILES_UP_move a,\n" +
                "\tggbak.dpk_move b \n" +
                "WHERE\n" +
                "\ta.cp_id = b.sb_id \n" +
                "\t";
        System.out.println(s13);
    }

    public static String getCode(String param){
        String[] paramArr = param.split("/");
        String res = "";
        for(String str:paramArr){
            res += map.get(str) +"/";
        }
        return res.substring(0,res.length()-1);
    }

}
