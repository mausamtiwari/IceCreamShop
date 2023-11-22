package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Magnum;

// This class is used as parameter inside IceCreamCar and iceCream Salon Constructor.
public class PriceList {
    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;

    public PriceList() {
    }

    // Displays the price list each time this constructor is called.
    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice) {
        this.ballPrice = ballPrice;
        this.rocketPrice = rocketPrice;
        this.magnumStandardPrice = magnumStandardPrice;

        System.out.println("********** Welcome to our ICE-CREAM SHOP **********");
        System.out.println();
        System.out.println("******************* PRICE-LIST ********************");
        System.out.println("MILKCHOCOLATE : €" + getMagnumPrice(Magnum.MagnumType.MILKCHOCOLATE));
        System.out.println("WHITECHOCOLATE : €" + getMagnumPrice(Magnum.MagnumType.WHITECHOCOLATE));
        System.out.println("BLACKCHOCOLATE : €" + getMagnumPrice(Magnum.MagnumType.BLACKCHOCOLATE));
        System.out.println("ALPINENUTS : €" + getMagnumPrice(Magnum.MagnumType.ALPINENUTS));
        System.out.println("ROMANTICSTRAWBERRIES : €" + getMagnumPrice(Magnum.MagnumType.ROMANTICSTRAWBERRIES));
        System.out.println("Each ball : €" + getBallPrice());
        System.out.println("IceRocket : €" + getRocketPrice());
        System.out.println("***************************************************");
        System.out.println();
    }

    // Getters and setters
    public double getBallPrice() {
        return ballPrice;
    }

    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    public double getMagnumPrice(Magnum.MagnumType type) {
        double magnumPrice = 0.0;
        if (type == Magnum.MagnumType.MILKCHOCOLATE) {
            magnumPrice = magnumStandardPrice * 2.0;
        } else if (type == Magnum.MagnumType.WHITECHOCOLATE) {
            magnumPrice = magnumStandardPrice * 2.5;
        } else if (type == Magnum.MagnumType.BLACKCHOCOLATE) {
            magnumPrice = magnumStandardPrice * 2.5;
        } else if (type == Magnum.MagnumType.ALPINENUTS) {
            magnumPrice = magnumStandardPrice * 1.5;
        } else if (type == Magnum.MagnumType.ROMANTICSTRAWBERRIES) {
            magnumPrice = magnumStandardPrice;
        } else {
            System.out.println("We don't have the chosen Magnum Type.");
        }
        return magnumPrice;
    }

    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }

}
