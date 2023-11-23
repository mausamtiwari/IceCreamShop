package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.PriceList;

import static be.intecbrussel.eatables.Cone.Flavor.*;

// Here only profit is taken care of.
public class IceCreamApp {
    public static void main(String[] args) {
        // PriceList instantiated.
        PriceList priceList = new PriceList(3.0, 2.5, 2.0);

        // IceCreamSalon instantiated with price list.
        IceCreamSalon iceCreamSalon = new IceCreamSalon(priceList);

        // Eatables of size 15 created. Where we add the orders from IceCreamSalon class.
        Eatable[] eatables = new Eatable[15];
        eatables[0] = iceCreamSalon.orderIceRocket();
        eatables[1] = iceCreamSalon.orderIceRocket();
        eatables[2] = iceCreamSalon.orderIceRocket();
        eatables[3] = iceCreamSalon.orderCone(new Cone.Flavor[]{STRACIATELLA, BANANA});
        eatables[4] = iceCreamSalon.orderCone(new Cone.Flavor[]{STRAWBERRY, CHOCOLATE});
        eatables[5] = iceCreamSalon.orderCone(new Cone.Flavor[]{VANILLA, LEMON});
        eatables[6] = iceCreamSalon.orderCone(new Cone.Flavor[]{MOKKA, PISTACHE});
        eatables[7] = iceCreamSalon.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
        eatables[8] = iceCreamSalon.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);
        eatables[9] = iceCreamSalon.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);

        // Displays what you ordered.
        for (Eatable eatable : eatables) {
            if (eatable != null) {
                eatable.eat();
            }
        }

        // Displays profit.
        System.out.println();
        System.out.println("Total profit: €" + iceCreamSalon.getProfit());
    }
}
