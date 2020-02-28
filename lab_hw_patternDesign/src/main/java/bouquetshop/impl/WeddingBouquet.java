package bouquetshop.impl;

import shopfloure.Bouquet;
import shopfloure.impl.flower.Color;
import shopfloure.impl.flower.Rose;

import java.util.LinkedList;
import java.util.List;

public class WeddingBouquet implements Bouquet {
    private int price;
    private List<Rose> flowers;

    public WeddingBouquet() {
        flowers = new LinkedList<>();
        for (int i = 0; i < 11; i++) {
            flowers.add(new Rose(Color.WHITE));
            if (i % 2 == 0) {
                flowers.add(new Rose(Color.RED));
            }
        }
        price = flowers.stream().mapToInt(Rose::getPrice).sum();
    }

    @Override
    public int getCost() {
        return price;
    }

    @Override
    public String getName() {
        return "WeddingBouquet";
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