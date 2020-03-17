package bouquetshop.factory;

import shopfloure.Bouquet;
import shopfloure.BouquetType;

public abstract class CelebrationFactory {
    public abstract Bouquet createBouquet(BouquetType type);
}
