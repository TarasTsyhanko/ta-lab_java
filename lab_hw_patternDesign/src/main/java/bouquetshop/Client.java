package bouquetshop;

import bouquetshop.enumtype.BouquetType;
import bouquetshop.enumtype.EventType;
import shopfloure.decorator.BouquetDecorator;
import shopfloure.decorator.impl.Delivery;
import shopfloure.decorator.impl.Discount;
import shopfloure.decorator.impl.Flower;
import shopfloure.decorator.impl.Wrapping;
import shopfloure.factory.AbstractFactory;
import shopfloure.factory.CelebrationFactory;
import shopfloure.impl.flower.Rose;

public class Client {

  public static void main(String[] args) {
    CelebrationFactory factory = new AbstractFactory().createFactory(EventType.WEDDING);
    Bouquet bouquet = factory.createBouquet(BouquetType.SIMPLE);
    BouquetDecorator delivery  = new Delivery();
    BouquetDecorator discount = new Discount();
    BouquetDecorator wrapping = new Wrapping();
    BouquetDecorator flower = new Flower(shopfloure.impl.flower.Color.RED);

    delivery.setBouquet(bouquet);
    flower.setBouquet(delivery);
    wrapping.setBouquet(flower);
    discount.setBouquet(wrapping);
    Bouquet fullBouquet = discount ;



    double price = fullBouquet.getCost();
    String name = fullBouquet.getName();

    System.out.println("price: " + price);
    System.out.println("name: " + name);
    System.out.println("COMPONENTS ===================");
    fullBouquet.showComponents();
  }
}
