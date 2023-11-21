package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

import static be.intecbrussel.eatables.Cone.Flavor.*;
import static be.intecbrussel.eatables.Cone.Flavor.PISTACHE;

public class IceCreamAppV2 {
    public static void main(String[] args) {
        PriceList priceList = new PriceList(2.5, 3, 3.5);
        Stock stock = new Stock(2, 3, 2, 2);
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, stock);

        Eatable[] eatables = new Eatable[15];
        eatables[0] = iceCreamCar.orderIceRocket();
        eatables[1] = iceCreamCar.orderCone(new Cone.Flavor[]{STRACIATELLA, BANANA});
        eatables[2] = iceCreamCar.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
        eatables[3] = iceCreamCar.orderIceRocket();
        eatables[4] = iceCreamCar.orderIceRocket();
        eatables[5] = iceCreamCar.orderCone(new Cone.Flavor[]{STRACIATELLA, BANANA});
        eatables[6] = iceCreamCar.orderCone(new Cone.Flavor[]{STRACIATELLA, BANANA});


        for (Eatable eatable : eatables) {
            if (eatable != null) {
                eatable.eat();
            }
        }

        System.out.println("Total profit: " + iceCreamCar.getProfit());


    }
}
