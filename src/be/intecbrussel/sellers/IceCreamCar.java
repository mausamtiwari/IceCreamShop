package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

import java.util.Arrays;

public class IceCreamCar implements IceCreamSeller {
    private final PriceList priceList;
    private final Stock stock;
    private double profit;


    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
        this.profit = getProfit();
    }

    // Manages stock and creates new cone.
    private Cone prepareCone(Cone.Flavor[] balls) {
        // Checks if there are enough cones and balls in stock.
        if (stock.getCones() > 0 && stock.getBalls() > 0) {
            // Gets the smallest amount of balls. Handy if user asks for the balls more than it is in stock.
            int availableBalls = Math.min(stock.getBalls(), balls.length);
            // Check if there are enough cones to create a new cone.
            if (stock.getCones() > 0) {
                // Decrease the stock of balls and cones each time Cones is prepared.
                stock.setBalls(stock.getBalls() - availableBalls);
                stock.setCones(stock.getCones() - 1);
                // Return a new cone with the available balls.
                return new Cone(Arrays.copyOf(balls, availableBalls));
            }
        }
        // Prints the message if balls or cones are out of stock.
        if (stock.getCones() <= 0) {
            System.out.println("Cones out of stock.");
        } else if (stock.getBalls() <= 0) {
            System.out.println("Balls out of stock.");
        }
        return null;
    }

    // Overridden from IceCreamSeller interface. Calculates profit.
    @Override
    public Cone orderCone(Cone.Flavor[] balls) {
        // Calls prepareCone.
        Cone preparedCone = prepareCone(balls);
        // Calculates profit if a cone is successfully prepared.
        if (preparedCone != null) {
            profit += balls.length * priceList.getBallPrice();
        }
        // Returns the stock and total profit of Cones.
        return preparedCone;
    }

    // Manages stock and creates new IceRocket.
    private IceRocket prepareRocket() {
        // Checks if there are enough IceRockets in stock.
        if (stock.getIceRockets() > 0) {
            // Decreases the stock of IceRockets each time new IceRocket is prepared.
            stock.setIceRockets(getStock().getIceRockets() - 1);
            // Returns IceRocket.
            return new IceRocket();
        } else {
            // Prints if IceRockets out of stock.
            System.out.println("IceRocket out of stock.");
            return null;
        }
    }

    // Overridden from IceCreamSeller interface. Calculates profit.
    @Override
    public IceRocket orderIceRocket() {
        // Calls prepareRocket.
        IceRocket preparedRocket = prepareRocket();
        // Calculates profit if an IceRocket is successfully prepared.
        if (preparedRocket != null) {
            profit += priceList.getRocketPrice();
        }
        // Returns total profit and the stock of IceRocket.
        return preparedRocket;
    }

    // Manages stock and creates new Magnum.
    private Magnum prepareMagnum(Magnum.MagnumType type) {
        // Checks if there are enough Magnums in stock.
        if (stock.getMagni() > 0) {
            // Decreases the stock of Magnums by one each time new Magnum is prepared.
            stock.setMagni(getStock().getMagni() - 1);
            // Returns new Magnum of various types.
            return new Magnum(type);
        } else {
            // Prints if magnum is out of stock.
            System.out.println("Magnum out of stock.");
            return null;
        }
    }

    // Overridden from IceCreamSeller interface. Calculates profit.
    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        // Calls prepareMagnum.
        Magnum preparedMagnum = prepareMagnum(type);
        // Calculates profit if Magnum is successfully prepared.
        if (preparedMagnum != null) {
            profit += priceList.getMagnumPrice(type);
        }
        // Returns total profit and the stock of Magnum.
        return preparedMagnum;
    }

    // Overridden from profitable. IceCreamSeller extends profitable and IceCreamCar implements IceCreamSeller.
    @Override
    public double getProfit() {
        return profit;
    }

    // Gets stock
    public Stock getStock() {
        return stock;
    }

    // Gets stock of individual elements to display the final stock .
    public void iceRocketStock() {
        System.out.println("IceRocket stock: " + getStock().getIceRockets());
    }

    public void conesStock() {
        System.out.println("Cones stock: " + getStock().getCones());
    }

    public void ballsStock() {
        System.out.println("Balls stock: " + getStock().getBalls());
    }

    public void magnumStock() {
        System.out.println("Magnum stock: " + getStock().getMagni());
    }

    public void orderedRocket() {

        // System.out.println("Totaal IceRockets ordered :" + (stocks.getIceRockets() - getStock().getIceRockets()));
    }

    public void orderedCone() {
        // System.out.println("Totaal Cones ordered :" + (stocks.getCones() - getStock().getCones()));
    }

    public void orderedMagni() {
        //System.out.println("Totaal Magni ordered :" + (stocks.getMagni() - getStock().getMagni()));
    }
}
