package Builder.entity;

import Builder.inter.Cailiao;

public class Bag  extends Package{
    @Override
    public String name() {
        return "塑料袋";
    }

    @Override
    public Cailiao cailiao() {
        return new Suliao();
    }
}
