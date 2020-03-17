package bouquetshop.decorator.impl;

import shopfloure.decorator.BouquetDecorator;

public class Delivery extends BouquetDecorator {
    private final int ADDITIONAL_PRICE = 100;
    private final String TO_NAME = " + Delivery";

    public Delivery() {
        setAdditionalPrice(ADDITIONAL_PRICE);
        setToName(TO_NAME);
    }
}
