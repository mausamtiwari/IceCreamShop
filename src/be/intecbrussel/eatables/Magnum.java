package be.intecbrussel.eatables;

public class Magnum implements Eatable {
   private MagnumType type;

    public Magnum() {

    }

    public Magnum(MagnumType type) {
        this.type = type;
    }

    public MagnumType getType() {
        return type;
    }

    // Overridden from Eatable interface and gets called in the main to print the type of Magnum ordered.
    @Override
    public void eat() {
        System.out.println("Ordered " + getType());
    }

    // Enum with types of Magnum. Used in Icecream Salon and IceCream Car to order and prepare Magnum
    // with different types.
    public enum MagnumType {
        MILKCHOCOLATE,
        WHITECHOCOLATE,
        BLACKCHOCOLATE,
        ALPINENUTS,
        ROMANTICSTRAWBERRIES,
    }

}
