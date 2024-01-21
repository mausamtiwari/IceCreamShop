import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.PriceList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IceCreamSalonTest {

    @ParameterizedTest
    @MethodSource("coneOrders")
    void orderConeTest(Cone.Flavor[] flavors, double expectedProfit) {
        PriceList priceList = new PriceList(3.0, 2.5, 2.0);
        IceCreamSalon iceCreamSalon = new IceCreamSalon(priceList);

        Cone orderedCone = iceCreamSalon.orderCone(flavors);

        Assertions.assertNotNull(orderedCone);
        Assertions.assertEquals(expectedProfit, iceCreamSalon.getProfit());
    }

    private static Stream<Arguments> coneOrders() {
        return Stream.of(
                Arguments.of(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY, Cone.Flavor.VANILLA}, 2 * 3.0),
                Arguments.of(new Cone.Flavor[]{Cone.Flavor.CHOCOLATE, Cone.Flavor.BANANA, Cone.Flavor.VANILLA}, 3 * 3.0),
                Arguments.of(new Cone.Flavor[]{Cone.Flavor.PISTACHE, Cone.Flavor.MOKKA, Cone.Flavor.LEMON, Cone.Flavor.STRACIATELLA}, 4 * 3.0)
        );
    }

    @ParameterizedTest
    @MethodSource("rocketOrders")
    void orderIceRocketTest(double expectedProfit) {
        PriceList priceList = new PriceList(3.0, 2.5, 2.0);
        IceCreamSalon iceCreamSalon = new IceCreamSalon(priceList);

        IceRocket orderedRocket = iceCreamSalon.orderIceRocket();

        Assertions.assertNotNull(orderedRocket);
        Assertions.assertEquals(expectedProfit, iceCreamSalon.getProfit());
    }

    private static Stream<Arguments> rocketOrders() {
        return Stream.of(
                Arguments.of(2.5),
                Arguments.of(2.5),
                Arguments.of(2.5)
        );
    }


    @ParameterizedTest
    @MethodSource("magnumOrders")
    void orderMagnumTest(Magnum.MagnumType magnumType, double expectedProfit) {
        PriceList priceList = new PriceList(3.0, 2.5, 2.0);
        IceCreamSalon iceCreamSalon = new IceCreamSalon(priceList);

        Magnum orderedMagnum = iceCreamSalon.orderMagnum(magnumType);

        Assertions.assertNotNull(orderedMagnum);
        Assertions.assertEquals(priceList.getMagnumPrice(magnumType), iceCreamSalon.getProfit());
    }

    private static Stream<Arguments> magnumOrders() {
        return Stream.of(
                Arguments.of(Magnum.MagnumType.ALPINENUTS, 0.06),
                Arguments.of(Magnum.MagnumType.MILKCHOCOLATE, 0.044),
                Arguments.of(Magnum.MagnumType.WHITECHOCOLATE, 0.056)
        );
    }





}
