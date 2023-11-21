package be.intecbrussel.eatables;


import java.util.Arrays;

public class Cone implements Eatable {
    Flavor[] balls;

    public Cone() {

    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }


    @Override
    public void eat() {
        System.out.println("Eating Cone ice cream with " + Arrays.toString(balls) + " flavors.");
    }

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
