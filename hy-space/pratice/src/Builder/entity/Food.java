package Builder.entity;

import Builder.inter.Item;
import Builder.inter.Pack;

public abstract class Food implements Item {


    @Override
    public Pack pack() {
        return new Bag();
    }
}
