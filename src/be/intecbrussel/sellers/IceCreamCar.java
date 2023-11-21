package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

import java.util.Arrays;


public class IceCreamCar implements IceCreamSeller {

    PriceList priceList;
    Stock stock;
    double profit;

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
        this.profit = 0.0;
    }


    private Cone prepareCone(Cone.Flavor[] balls) {
        // Checks of there is stock of cones and balls.
        if (stock.getCones() > 0 && stock.getBalls() > 0) {
            // Checks if there is enough stock of balls. If there's  stock of balls updates stock and creates cone.
            if (stock.getBalls() >= balls.length) {
                profit += balls.length * priceList.getBallPrice();
                stock.setBalls(getStock().getBalls() - balls.length);
                stock.setCones(getStock().getCones() - 1);
                System.out.println("Balls stock: " + stock.getBalls());
                System.out.println("Cones stock: " + stock.getCones());
                return new Cone(balls);
            } else { // If there is insufficient balls, calculates profit with available balls and updates cone's stock.
                profit += balls.length * priceList.getBallPrice();
                stock.setBalls(getStock().getBalls()- balls.length);
                stock.setCones(getStock().getCones() - 1);
                System.out.println("Balls stock: " + stock.getBalls());
                System.out.println("Cones stock: " + stock.getCones());
                System.out.println("Balls out of stock.");
                return new Cone(Arrays.copyOf(balls, stock.getBalls()));
            }
        }
        System.out.println("Cones out of stock.");
        return null;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] balls) {
        return prepareCone(balls);
    }


    private IceRocket prepareRocket() {
        if (stock.getIceRockets() > 0) {
            profit += priceList.getRocketPrice();
            stock.setIceRockets(getStock().getIceRockets() - 1);
            return new IceRocket();
        } else {
            System.out.println("IceRocket out of stock.");
            return null;
        }
    }

    @Override
    public IceRocket orderIceRocket() {
        return prepareRocket();
    }


    private Magnum prepareMagnum(Magnum.MagnumType type) {
        if (stock.getMagni() > 0) {
            profit += priceList.getMagnumPrice(type);
            stock.setMagni(getStock().getMagni() - 1);
            return new Magnum(type);
        } else {
            System.out.println("Magnum out of stock.");
            return null;
        }
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        return prepareMagnum(type);
    }


    @Override
    public double getProfit() {
        return profit;
    }

    public Stock getStock() {
        return stock;
    }
}
