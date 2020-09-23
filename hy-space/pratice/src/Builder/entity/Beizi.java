package Builder.entity;

import Builder.inter.Cailiao;

public class Beizi extends  Package {
    @Override
    public String name() {
        return "一次性杯子";
    }

    @Override
    public Cailiao cailiao() {
        return new Suliao();
    }
}
