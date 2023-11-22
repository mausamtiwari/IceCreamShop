package be.intecbrussel.eatables;

public class IceRocket implements Eatable {
    public IceRocket() {

    }

    // Overridden from Eatable interface and gets called in the main to print the IceRocket ordered.
    @Override
    public void eat() {
        System.out.println("Ordered IceRocket.");
    }
}

