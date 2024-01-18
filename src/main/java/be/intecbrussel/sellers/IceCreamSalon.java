package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller {
    private  PriceList priceList;
    private double totalProfit;


    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }

    // Overridden from profitable. IceCreamSeller extends profitable and IceCreamSalon
    // implements IceCreamSeller.
    @Override
    public double getProfit() {
        return this.totalProfit;
    }

    // Overridden from IceCreamSeller and creates new Cone with balls and updates profit.
    @Override
    public Cone orderCone(Cone.Flavor[] balls) {
        Cone cones = new Cone(balls);
        totalProfit += priceList.getBallPrice() * balls.length;
        return cones;
    }

    // Overridden from IceCreamSeller and creates new IceRocket and updates profit.
    @Override
    public IceRocket orderIceRocket() {
        IceRocket iceRocket = new IceRocket();
        totalProfit += priceList.getRocketPrice();
        return iceRocket;
    }

    // Overridden from IceCreamSeller and creates new Magnum with types and updates profit.
    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        Magnum magnum = new Magnum(type);
        totalProfit += priceList.getMagnumPrice(type);
        return magnum;
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" +
                "priceList=" + priceList +
                ", totalProfit=" + totalProfit +
                '}';
    }
}
