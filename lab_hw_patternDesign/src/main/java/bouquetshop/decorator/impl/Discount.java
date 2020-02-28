package bouquetshop.decorator.impl;

import shopfloure.decorator.BouquetDecorator;

public class Discount extends BouquetDecorator {
    private final int DISCOUNT = 40;
    private final String TO_NAME = " + Discount";

    public Discount() {
        setAdditionalPrice(-DISCOUNT);
        setToName(TO_NAME);
    }
}
