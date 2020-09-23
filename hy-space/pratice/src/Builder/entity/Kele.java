package Builder.entity;

import Builder.inter.Pack;

public class Kele extends Drink{
    @Override
    public String name() {
        return "可口可乐";
    }

    @Override
    public float price() {
        return 3;
    }

    @Override
    public Pack pack() {
        return new Beizi();
    }
}
