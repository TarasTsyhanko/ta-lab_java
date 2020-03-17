package bouquetshop.decorator;

import shopfloure.Bouquet;
import shopfloure.impl.flower.Color;
import shopfloure.impl.flower.Rose;

import java.util.List;
import java.util.Optional;

public class BouquetDecorator implements Bouquet {
    private Optional<Bouquet> bouquet;
    private int additionalPrice;
    protected String toName = "";
    private Rose additionalComponent;

    public void setBouquet(Bouquet ourBouquet) {
        bouquet = Optional.ofNullable(ourBouquet);
        if (additionalComponent != null) {
            bouquet.orElseThrow(IllegalArgumentException::new).getBouquet().add(additionalComponent);
        }
    }

    public void setAdditionalPrice(int additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    public void setAdditionalComponent(Rose additionalComponent) {
        this.additionalComponent = additionalComponent;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    @Override
    public int getCost() {
        return bouquet.orElseThrow(IllegalArgumentException::new).getCost() + additionalPrice;
    }

    @Override
    public String getName() {
        return bouquet.orElseThrow(IllegalArgumentException::new).getName() + toName;
    }

    @Override
    public void showComponents() {
        System.out.println("Rose RED   " + (int) getBouquet().stream().filter(r -> r.getColor() == Color.RED).count());
        System.out.println("Rose WHITE " + (int) getBouquet().stream().filter(r -> r.getColor() == Color.WHITE).count());
        System.out.println("Rose PINK  " + (int) getBouquet().stream().filter(r -> r.getColor() == Color.PINK).count());
    }

    @Override
    public List<Rose> getBouquet() {
        return bouquet.orElseThrow(IllegalArgumentException::new).getBouquet();
    }
}
