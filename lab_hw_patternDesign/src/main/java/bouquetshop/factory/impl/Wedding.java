package bouquetshop.factory.impl;

import shopfloure.Bouquet;
import shopfloure.BouquetType;
import shopfloure.factory.CelebrationFactory;
import shopfloure.impl.*;

public class Wedding extends CelebrationFactory {
    @Override
    public Bouquet createBouquet(BouquetType type) {
        Bouquet bouquet = null;
        if (type == BouquetType.MY) {
            bouquet = new MyBouquet();
        } else if (type == BouquetType.ROYAL) {
            bouquet = new WeddingRoyalBouquet();
        } else if (type == BouquetType.SIMPLE){
            bouquet = new WeddingBouquet();
        }
        return bouquet;
    }
}
