package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

// This interface is implemented to IceCreamCar and IceCreamSalon.
public interface IceCreamSeller extends Profitable {
    Cone orderCone(Cone.Flavor[] balls);

    IceRocket orderIceRocket();

    Magnum orderMagnum(Magnum.MagnumType type);


}
