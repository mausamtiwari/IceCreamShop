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
        Stock stock = new Stock(2, 3, 8, 8);

        // IceCreamCar instantiated with price list and stock.
        IceCreamSeller iceCreamSeller = new IceCreamCar(priceList, stock);

        // Eatables of size 15 created. Where we add the orders from IceCreamCar class.
        Eatable[] eatables = new Eatable[15];

        eatables[0] = iceCreamSeller.orderIceRocket();
        eatables[1] = iceCreamSeller.orderIceRocket();
        eatables[2] = iceCreamSeller.orderIceRocket();
        eatables[3] = iceCreamSeller.orderCone(new Cone.Flavor[]{STRACIATELLA, BANANA, LEMON});
        eatables[4] = iceCreamSeller.orderCone(new Cone.Flavor[]{STRAWBERRY, CHOCOLATE});
        eatables[5] = iceCreamSeller.orderCone(new Cone.Flavor[]{VANILLA, LEMON});
        eatables[6] = iceCreamSeller.orderCone(new Cone.Flavor[]{MOKKA, PISTACHE});
        eatables[7] = iceCreamSeller.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
        eatables[8] = iceCreamSeller.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);
        eatables[9] = iceCreamSeller.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);
        eatables[10] = iceCreamSeller.orderMagnum(Magnum.MagnumType.ALPINENUTS);
        eatables[11] = iceCreamSeller.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);

        // Displays what you ordered.
        for (Eatable eatable : eatables) {
            if (eatable != null) {
                eatable.eat();
            }
        }

        // Displays the final stock from IceCreamCar class.
        System.out.println();
        System.out.println("******************* Final Stocks ******************");
        System.out.println("IceRockets stock: " + ((IceCreamCar) iceCreamSeller).finalIceRocketStock());
        System.out.println("Cones stock: " + ((IceCreamCar) iceCreamSeller).finalConesStock());
        System.out.println("Balls stock : " + ((IceCreamCar) iceCreamSeller).finalBallsStock());
        System.out.println("Magnum stock: " + ((IceCreamCar) iceCreamSeller).finalMagniStock());
        System.out.println();

        // Displays the total profit.
        System.out.println("Total profit: €" + iceCreamSeller.getProfit());
    }
}

/* Even though there is not enough balls in stock, clients are served with available balls. For example if there
   is only 2 balls in stock but clients ordered 3 balls in first cone and 2 in second cone, s/he shall be served
   with 2 available balls in first cone and for the second cone ordered, the program prints "Balls out of stock".
   But there must be enough cone to make an order. Else, the program prints "Cone out of stock" each time a new
   cone is ordered."

   The program displays the welcome message at the top, price list of ice creams and initial stock below.
   Count of final stock is also made and displayed. And at last the total profit made is displayed. */
