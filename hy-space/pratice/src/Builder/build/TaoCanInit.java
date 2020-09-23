package Builder.build;

import Builder.inter.Item;

import java.util.ArrayList;
import java.util.List;

public class TaoCanInit {

        private List<Item> items = new ArrayList<>();

        public void addItem(Item item){
            items.add(item);
        }

        public float cost(){
            float cost = 0;
            for(Item item:items){
                cost+= item.price();
            }
            return cost;
        }

        public String getTaoCanNeiRong(){
            StringBuffer buffer = new StringBuffer();
            for(Item item:items){
                buffer.append("名:"+item.name()).append(";").append("\n");
                buffer.append("价格:").append(item.price()).append("\n");
                buffer.append("包装").append(item.pack().name()).append("材料").append(item.pack().cailiao().name()).append(")").append("\n");
            }
            return  buffer.toString();
        }

}
