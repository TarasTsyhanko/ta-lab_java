package bouquetshop.factory;

import shopfloure.EventType;
import shopfloure.factory.impl.BirthDay;
import shopfloure.factory.impl.Valentine;
import shopfloure.factory.impl.Wedding;

public class AbstractFactory {
    public CelebrationFactory createFactory(EventType day){
        CelebrationFactory factory = null;
        if (day == EventType.WEDDING){
            factory = new Wedding();
        } else if (day == EventType.BIRTHDAY){
            factory = new BirthDay();
        }else if (day == EventType.VALENTINE){
            factory = new Valentine();
        }
        return factory;
    }
}
