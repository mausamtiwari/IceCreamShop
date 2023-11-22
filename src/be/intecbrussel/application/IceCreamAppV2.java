package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

import static be.intecbrussel.eatables.Cone.Flavor.*;

// Both stock and profit is taken care of.
public class IceCreamAppV2 {
    public static void main(String[] args) {
        // PriceList instantiated.
        PriceList priceList = new PriceList(3.0, 2.5, 2.0);

        // Stock instantiated.
        Stock stock = new Stock(2, 6, 12, 10);

        // IceCreamCar instantiated with price list and stock.
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, stock);

        // Eatables of size 15 created. Where we add the orders from IceCreamCar class.
        Eatable[] eatables = new Eatable[15];

        eatables[0] = iceCreamCar.orderIceRocket();
        eatables[1] = iceCreamCar.orderIceRocket();
        eatables[2] = iceCreamCar.orderIceRocket();
        eatables[3] = iceCreamCar.orderCone(new Cone.Flavor[]{STRACIATELLA, BANANA, LEMON});
        eatables[4] = iceCreamCar.orderCone(new Cone.Flavor[]{STRAWBERRY, CHOCOLATE});
        eatables[5] = iceCreamCar.orderCone(new Cone.Flavor[]{VANILLA, LEMON});
        eatables[6] = iceCreamCar.orderCone(new Cone.Flavor[]{MOKKA, PISTACHE});
        eatables[7] = iceCreamCar.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
        eatables[8] = iceCreamCar.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);
        eatables[9] = iceCreamCar.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);

        // Displays what you ordered.
        for (Eatable eatable : eatables) {
            if (eatable != null) {
                eatable.eat();
            }
        }

        // Displays the final stock.
        System.out.println();
        System.out.println("******************* Final Stocks ******************");
        iceCreamCar.iceRocketStock();
        iceCreamCar.conesStock();
        iceCreamCar.ballsStock();
        iceCreamCar.magnumStock();
        System.out.println();

        // Displays the total profit.
        System.out.println("Total profit: €" + iceCreamCar.getProfit());

    }
}
