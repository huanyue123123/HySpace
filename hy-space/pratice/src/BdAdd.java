import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Stack;

public class BdAdd {

    public static void main(String[] args) {
        Double[] s = new Double[]{5.0,3.0,2.0,5.0,5.0,5.0,18.0,20.0};
        Stack<Double> stack = new Stack();
        stack.addAll(Arrays.asList(s));

        BigDecimal dataScoreBD = new BigDecimal(0.0);
        while (stack.size() > 0){
            dataScoreBD = dataScoreBD.add(new BigDecimal(stack.pop()));
        }
        System.out.println(dataScoreBD);



    }
}
