package be.intecbrussel.eatables;

import java.util.Arrays;

public class Cone implements Eatable {
   private Flavor[] balls;

    public Cone() {

    }

    // Cone gets balls of Flavor[] from flavor enum.
    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    // Overridden from Eatable interface and gets called in the main to print flavors and balls ordered.
    @Override
    public void eat() {
        System.out.println("Ordered cone with " + Arrays.toString(balls) + " flavors.");
    }

    // Enum with different flavors. Used in Icecream Salon and IceCream Car to prepare and order the cone
    // with different flavors.
    public enum Flavor {
        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        LEMON,
        STRACIATELLA,
        MOKKA,
        PISTACHE,
    }
}
