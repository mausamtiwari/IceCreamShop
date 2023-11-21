package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.PriceList;

import static be.intecbrussel.eatables.Cone.Flavor.*;

public class IceCreamApp {
    public static void main(String[] args) {
        PriceList priceList = new PriceList(2.5, 3, 3.0);
        IceCreamSalon iceCreamSalon = new IceCreamSalon(priceList);

        Eatable[] eatables = new Eatable[10];
        eatables[0] = iceCreamSalon.orderIceRocket();
        eatables[1] = iceCreamSalon.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
        eatables[2] = iceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINENUTS);
        eatables[3] = iceCreamSalon.orderCone(new Cone.Flavor[]{STRAWBERRY, BANANA,
                VANILLA, LEMON, MOKKA, PISTACHE});

        for (Eatable eatable : eatables) {
            if (eatable != null) {
                eatable.eat();
            }
        }

        System.out.println("Total profit: " + iceCreamSalon.getProfit());
    }
}
