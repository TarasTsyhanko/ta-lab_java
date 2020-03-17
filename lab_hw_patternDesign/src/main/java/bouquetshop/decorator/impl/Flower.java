package bouquetshop.decorator.impl;

import shopfloure.decorator.BouquetDecorator;
import shopfloure.impl.flower.Color;
import shopfloure.impl.flower.Rose;

public class Flower extends BouquetDecorator {

    public Flower(shopfloure.impl.flower.Color color) {
        Rose rose = null;
        if(color == Color.RED){
            rose = new Rose(shopfloure.impl.flower.Color.RED);
            setAdditionalComponent(rose);
        }else if (color==Color.PINK){
            rose = new Rose( Color.PINK);
            setAdditionalComponent(rose);
        }else if (color==Color.WHITE){
            rose = new Rose(Color.WHITE);
            setAdditionalComponent(rose);
        }
        assert rose != null;
        setAdditionalPrice(rose.getPrice());
    }
}
