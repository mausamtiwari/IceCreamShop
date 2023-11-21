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
        this.profit = getProfit();
    }


    private Cone prepareCone(Cone.Flavor[] balls) {
        // Check if there are enough cones and balls in stock
        if (stock.getCones() > 0 && stock.getBalls() > 0) {
            int availableBalls = Math.min(stock.getBalls(), balls.length);
            // Check if there are enough cones to create a new cone
            if (stock.getCones() > 0) {
                // Decrease the stock of balls and cones
                stock.setBalls(stock.getBalls() - availableBalls);
                stock.setCones(stock.getCones() - 1);
                // Return a new cone with the available balls
                return new Cone(Arrays.copyOf(balls, availableBalls));
            }
        }
        // Print appropriate messages for stock shortage
        if (stock.getCones() == 0) {
            System.out.println("Cones out of stock.");
        } else if (stock.getBalls() == 0) {
            System.out.println("Balls out of stock.");
        }
        return null;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] balls) {
        // Call prepareCone to handle cone preparation
        Cone preparedCone = prepareCone(balls);
        // Calculate profit if a cone is successfully prepared
        if (preparedCone != null) {
            profit += balls.length * priceList.getBallPrice();
        }
        return preparedCone;
    }


    private IceRocket prepareRocket() {
        if (stock.getIceRockets() > 0) {
            stock.setIceRockets(getStock().getIceRockets() - 1);
            return new IceRocket();
        } else {
            System.out.println("IceRocket out of stock.");
            return null;
        }
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket preparedRocket = prepareRocket();
        if (preparedRocket != null) {
            profit += priceList.getRocketPrice();
        }
        return preparedRocket;
    }


    private Magnum prepareMagnum(Magnum.MagnumType type) {
        if (stock.getMagni() > 0) {
            stock.setMagni(getStock().getMagni() - 1);
            return new Magnum(type);
        } else {
            System.out.println("Magnum out of stock.");
            return null;
        }
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        Magnum preparedMagnum = prepareMagnum(type);
        if (preparedMagnum != null) {
            profit += priceList.getMagnumPrice(type);
        }
        return preparedMagnum;
    }

    @Override
    public double getProfit() {
        return profit;
    }

    public Stock getStock() {
        return stock;
    }
}
