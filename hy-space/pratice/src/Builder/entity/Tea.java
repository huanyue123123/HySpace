package Builder.entity;

import Builder.inter.Pack;

public class Tea  extends  Drink{
    @Override
    public String name() {
        return "茶";
    }

    @Override
    public float price() {
        return 20;
    }

    @Override
    public Pack pack() {
        return new TaociBeizi();
    }
}
