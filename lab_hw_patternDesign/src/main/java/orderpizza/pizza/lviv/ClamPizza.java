package orderpizza.pizza.lviv;

import orderpizza.pizza.LvivPizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClamPizza extends LvivPizza {
    private static final Logger LOG = LogManager.getLogger(ClamPizza.class);
    private int price = 115;

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
        LOG.info("Parmesan");
    }

    public void ingredient5() {
        LOG.info("Tomatoes");
    }

    public void ingredient6() {
        LOG.info("Pepper");
    }

    public void ingredient7() {
        LOG.info("Mozzarella");
    }

    public void prise() {
        LOG.info("total price: " + price);
    }
}
