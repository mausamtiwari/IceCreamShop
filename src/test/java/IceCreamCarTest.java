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


public class IceCreamCarTest {

    private PriceList priceList;
    private Stock stock;
    private double profit;
    private IceCreamCar iceCreamCar;

    {
        iceCreamCar = new IceCreamCar();
    }
    @ParameterizedTest
    @MethodSource("coneOrders")
    void orderConeTest(Cone.Flavor[] flavors) {
        PriceList priceList = new PriceList(3.0, 2.5, 2.0);
        Stock stock = new Stock(10, 10, 20, 15);
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, stock);

        Cone orderedCone = iceCreamCar.orderCone(flavors);

        Assertions.assertNotNull(orderedCone);
        Assertions.assertEquals(flavors.length * priceList.getBallPrice(), iceCreamCar.getProfit());
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
    void orderMagnumTest(Magnum.MagnumType magnumType) {
        PriceList priceList = new PriceList(3.0, 2.5, 2.0);
        Stock stock = new Stock(10, 10, 20, 15);
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, stock);

        Magnum orderedMagnum = iceCreamCar.orderMagnum(magnumType);

        Assertions.assertNotNull(orderedMagnum);
        Assertions.assertEquals(priceList.getMagnumPrice(magnumType), iceCreamCar.getProfit());
    }

    @Test
    void orderInvalidMagnumTest() {
        PriceList priceList = new PriceList(3.0, 2.5, 2.0);
        Stock stock = new Stock(0, 0, 0, 0);
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, stock);

        Magnum orderedMagnum = iceCreamCar.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);

        Assertions.assertNull(orderedMagnum);
        Assertions.assertEquals(0.0, iceCreamCar.getProfit());
    }
}
