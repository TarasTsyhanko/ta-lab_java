package bouquetshop.impl;

import shopfloure.Bouquet;
import shopfloure.impl.flower.Color;
import shopfloure.impl.flower.Rose;

import java.util.LinkedList;
import java.util.List;

public class BirthDayBouquet implements Bouquet {
    private int price;
    private List<Rose> flowers;

    public BirthDayBouquet() {
        flowers = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            flowers.add(new Rose(Color.WHITE));
        }
        price = flowers.stream().mapToInt(Rose::getPrice).sum();
    }

    @Override
    public int getCost() {
        return price;
    }

    @Override
    public String getName() {
        return "BirthDayBouquet";
    }

    @Override
    public List<Rose> getBouquet() {
        return flowers;
    }

    @Override
    public void showComponents() {
        System.out.println("Rose RED " + (int) flowers.stream().filter(r -> r.getColor() == Color.RED).count());
        System.out.println("Rose WHITE " + (int) flowers.stream().filter(r -> r.getColor() == Color.WHITE).count());
        System.out.println("Rose PINK " + (int) flowers.stream().filter(r -> r.getColor() == Color.PINK).count());
    }
}
