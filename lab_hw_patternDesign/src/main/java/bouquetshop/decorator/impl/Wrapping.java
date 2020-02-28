package bouquetshop.decorator.impl;

import shopfloure.decorator.BouquetDecorator;

public class Wrapping extends BouquetDecorator {
    private final int ADDITIONAL_PRICE = 45;
    private final String TO_NAME = " + Wrapping";

    public Wrapping() {
        setAdditionalPrice(ADDITIONAL_PRICE);
        setToName(TO_NAME);
    }
}
