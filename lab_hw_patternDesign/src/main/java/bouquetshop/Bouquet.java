package bouquetshop;

import shopfloure.impl.flower.Rose;

import java.util.List;

public interface Bouquet {
    int getCost();
    String getName();
    void showComponents();
    List<Rose> getBouquet();
}
