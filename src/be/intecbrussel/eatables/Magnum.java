package be.intecbrussel.eatables;

public class Magnum implements Eatable {
    MagnumType type;

    public Magnum(){

    }

    public Magnum(MagnumType type) {
        this.type = type;
    }

    public MagnumType getType() {
        return type;
    }

    @Override
    public void eat() {
        System.out.println("You eat " + getType());
    }

    public enum MagnumType {     // Enum with various flavors of Magnum ice cream.
        MILKCHOCOLATE,
        WHITECHOCOLATE,
        BLACKCHOCOLATE,
        ALPINENUTS,
        ROMANTICSTRAWBERRIES,

    }


}
