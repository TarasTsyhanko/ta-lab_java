package orderpizza.pizza.lviv;

import orderpizza.pizza.LvivPizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheesePizza extends LvivPizza {
    private static final Logger LOG = LogManager.getLogger(CheesePizza.class);
    private int price = 90;

    public CheesePizza() {
        LOG.info("Your order: CheesePizza");
    }

    public void diameter() {
        LOG.info("Pizza diameter 35 cm");
    }

    public void ingredient1() {
        LOG.info("Mozzarella");
    }

    public void ingredient2() {
        LOG.info("Camembert");
    }

    public void ingredient3() {
        LOG.info("Royal cheese");
    }

    public void ingredient4() {
        LOG.info("Walnut");
    }

    public void ingredient5() {
        LOG.info("Pepper");
    }

    public void ingredient6() {
        LOG.info("Basil");
    }

    public void ingredient7() {
        LOG.info("Tomatoes");
    }

    public void prise() {
        LOG.info("total price: " + price);
    }
}
