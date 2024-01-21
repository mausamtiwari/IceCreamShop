import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class IceCreamCarTest {

    @ParameterizedTest
    @MethodSource("flavorArguments")
    void orderConeTest(Cone.Flavor[] flavors, double expectedProfit) {
        PriceList priceList = new PriceList(3.0, 2.5, 2.0);
        Stock stock = new Stock(10, 10, 20, 15);
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, stock);

        Cone orderedCone = iceCreamCar.orderCone(flavors);

        Assertions.assertNotNull(orderedCone);
        Assertions.assertEquals(expectedProfit, iceCreamCar.getProfit());
    }

    private static Stream<Arguments> flavorArguments() {
        return Stream.of(
                Arguments.of(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY, Cone.Flavor.BANANA}, 2 * 3.0),
                Arguments.of(new Cone.Flavor[]{Cone.Flavor.VANILLA, Cone.Flavor.CHOCOLATE, Cone.Flavor.LEMON}, 3 * 3.0),
                Arguments.of(new Cone.Flavor[]{}, 0.0),
                Arguments.of(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY}, 1 * 3.0),
                Arguments.of(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY, Cone.Flavor.BANANA}, 2 * 3.0)
        );
    }


    @Test
    void orderIceRocketTest() {
        PriceList priceList = new PriceList(3.0, 2.5, 2.0);
        Stock stock = new Stock(10, 10, 20, 15);
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, stock);

        IceRocket orderedRocket = iceCreamCar.orderIceRocket();

        Assertions.assertNotNull(orderedRocket);
        Assertions.assertEquals(priceList.getRocketPrice(), iceCreamCar.getProfit());
    }


    @ParameterizedTest
    @MethodSource("magnumOrders")
    void orderMagnumTest(Magnum.MagnumType magnumType, double initialProfit, double expectedProfit) {
        PriceList priceList = new PriceList(3.0, 2.5, 2.0);
        Stock stock = new Stock(10, 10, 20, 15);
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, stock);
        iceCreamCar.setProfit(initialProfit); // Set initial profit

        Magnum orderedMagnum = iceCreamCar.orderMagnum(magnumType);

        Assertions.assertNotNull(orderedMagnum);
        double magnumPrice = priceList.getMagnumPrice(magnumType);
        Assertions.assertEquals(initialProfit + magnumPrice, iceCreamCar.getProfit(), 0.001);
    }

    private static Stream<Arguments> magnumOrders() {
        return Stream.of(
                Arguments.of(Magnum.MagnumType.ALPINENUTS, 0.0, 0.06),
                Arguments.of(Magnum.MagnumType.MILKCHOCOLATE, 0.0, 0.044),
                Arguments.of(Magnum.MagnumType.WHITECHOCOLATE, 0.0, 0.056),
                Arguments.of(Magnum.MagnumType.ROMANTICSTRAWBERRIES, 0.0, 0.08),
                Arguments.of(Magnum.MagnumType.BLACKCHOCOLATE, 0.0, 0.08)
        );
    }


}