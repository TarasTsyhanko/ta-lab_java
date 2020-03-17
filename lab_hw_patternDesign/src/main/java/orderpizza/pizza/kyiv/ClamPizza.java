package orderpizza.pizza.kyiv;

import orderpizza.pizza.KyivPizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClamPizza extends KyivPizza {
    private static final Logger LOG = LogManager.getLogger(ClamPizza.class);
    private int price = 110;

    public ClamPizza() {
        LOG.info("Your order: ClamPizza");
    }

    public void diameter() {
        LOG.info("Pizza diameter 30 cm");
    }

    public void ingredient1() {
        LOG.info("Clam");
    }

    public void ingredient2() {
        LOG.info("Shrimp");
    }

    public void ingredient3() {
        LOG.info("Onion");
    }

    public void ingredient4() {
        LOG.info("Olives");
    }

    public void ingredient5() {
        LOG.info("Tomatoes");
    }

    public void ingredient6() {
        LOG.info("Pepper");
    }

    public void prise() {
        LOG.info("total price: " + price);
    }
}
