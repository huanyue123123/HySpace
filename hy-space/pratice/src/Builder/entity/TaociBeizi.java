package Builder.entity;

import Builder.inter.Cailiao;

public class TaociBeizi extends  Package{
    @Override
    public String name() {
        return "陶瓷杯";
    }

    @Override
    public Cailiao cailiao() {
        return new Taoci();
    }
}
