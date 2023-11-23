package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;

import static be.intecbrussel.eatables.Cone.Flavor.*;

// Here only profit is taken care of.
public class IceCreamApp {
    public static void main(String[] args) {
        // PriceList instantiated.
        PriceList priceList = new PriceList(3.0, 2.5, 2.0);

        // IceCreamSalon instantiated with price list.
        IceCreamSeller iceCreamSeller = new IceCreamSalon(priceList);

        // Eatables of size 15 created. Where we add the orders from IceCreamSalon class.
        Eatable[] eatables = new Eatable[15];
        eatables[0] = iceCreamSeller.orderIceRocket();
        eatables[1] = iceCreamSeller.orderIceRocket();
        eatables[2] = iceCreamSeller.orderIceRocket();
        eatables[3] = iceCreamSeller.orderCone(new Cone.Flavor[]{STRACIATELLA, BANANA});
        eatables[4] = iceCreamSeller.orderCone(new Cone.Flavor[]{STRAWBERRY, CHOCOLATE});
        eatables[5] = iceCreamSeller.orderCone(new Cone.Flavor[]{VANILLA, LEMON});
        eatables[6] = iceCreamSeller.orderCone(new Cone.Flavor[]{MOKKA, PISTACHE});
        eatables[7] = iceCreamSeller.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
        eatables[8] = iceCreamSeller.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);
        eatables[9] = iceCreamSeller.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);

        // Displays what you ordered.
        for (Eatable eatable : eatables) {
            if (eatable != null) {
                eatable.eat();
            }
        }

        // Displays profit.
        System.out.println();
        System.out.println("Total profit: €" + iceCreamSeller.getProfit());
    }
}
