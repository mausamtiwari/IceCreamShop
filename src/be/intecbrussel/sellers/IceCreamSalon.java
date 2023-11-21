package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller {
    PriceList priceList;
    double totalProfit;


    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }

    @Override
    public double getProfit() {
        return this.totalProfit;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] balls) {     // Order cone method
        Cone cones = new Cone(balls);
        totalProfit += priceList.getBallPrice() * balls.length;
        return cones;
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket iceRocket = new IceRocket();
        totalProfit += priceList.getRocketPrice();
        return iceRocket;
    }

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
