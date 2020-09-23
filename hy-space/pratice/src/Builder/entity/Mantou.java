package Builder.entity;

public class Mantou extends  Food{
    @Override
    public String name() {
        return "馒头";
    }

    @Override
    public float price() {
        return 1;
    }
}
