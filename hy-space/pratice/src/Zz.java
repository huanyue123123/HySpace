import java.util.regex.Pattern;

public class Zz {

    public static void main(String[] args) {
        String str = "(L271C01)137.5(L271C01)/(L271D02)135.1(L271C01)";
        str = "137(23)+333(s)";
        str = "前：6/后:： 3 ";
        String re = str.replaceAll("((\\(|（).*?(\\)|）))*","").replaceAll("((前|后){1,}(:|：){1,})","");
        System.out.println(re);
        System.out.println(re.matches("(\\d+\\.*\\d*|\\d+\\.*\\d*(/|\\+)+)*"));

    }
}
