package Builder.build;

import Builder.entity.Kele;
import Builder.entity.Mantou;
import Builder.entity.Tea;
import Builder.entity.Xiancai;

public class TaoCan {

    public void taoCanA(){
        TaoCanInit taoCanInit = new TaoCanInit();
        taoCanInit.addItem(new Mantou());
        taoCanInit.addItem(new Xiancai());
        taoCanInit.addItem(new Tea());
        System.out.println(taoCanInit.cost());
        System.out.println(taoCanInit.getTaoCanNeiRong());
    }

    public void taoCanB(){
        TaoCanInit taoCanInit = new TaoCanInit();
        taoCanInit.addItem(new Mantou());
        taoCanInit.addItem(new Xiancai());
        taoCanInit.addItem(new Kele());
        System.out.println(taoCanInit.cost());
        System.out.println(taoCanInit.getTaoCanNeiRong());

    }

    public static void main(String[] args) {
        TaoCan taoCan = new TaoCan();
        taoCan.taoCanA();
        taoCan.taoCanB();
    }

}
