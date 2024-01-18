import be.intecbrussel.eatables.Cone;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Arrays;

public class IceCreamCarTest {

    private PriceList priceList;
    private Stock stock;
    private double profit;
    private IceCreamCar iceCreamCar;

    {
        iceCreamCar = new IceCreamCar();
    }
    @Test
    @ParameterizedTest
    public void orderConeTest(){
        priceList = new PriceList();
        stock = new Stock(1,0,1,1);
        profit = 1 * priceList.getBallPrice();

        double expectedResult = 0;
        Assertions.assertEquals(expectedResult,profit);
    }

}
