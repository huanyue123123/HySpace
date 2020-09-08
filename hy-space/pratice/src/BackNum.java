import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackNum {
    public static boolean isPalindrome(int x) {
        int copy = x;
        if(x < 0){
            return false;
        }
        int reverse = 0;
        List<Integer> list = new ArrayList<>();
        while(copy/10 > 0){
            list.add(copy%10);
            copy = copy/10;
        }
        list.add(copy);
        for(int i = 0;i<list.size();i++){
            int index = list.size() - i - 1;
            int rs = 1;
            for(int j = 0;j<index;j++){
                rs *= 10;
            }
            reverse  += rs*list.get(i);
        }

        return reverse == x;
    }



    public static void main(String[] args) {
        boolean s = isPalindrome(121);
        System.out.println(s);
    }
}
