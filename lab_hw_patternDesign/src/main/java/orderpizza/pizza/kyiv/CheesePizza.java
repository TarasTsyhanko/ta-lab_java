package orderpizza.pizza.kyiv;

import orderpizza.pizza.KyivPizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheesePizza extends KyivPizza {
    private static final Logger LOG = LogManager.getLogger(CheesePizza.class);
    private int price = 110;

    public CheesePizza() {
        LOG.info("Your order: CheesePizza");
    }

    public void diameter() {
        LOG.info("Pizza diameter 37 cm");
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
        LOG.info("Tomatoes");
    }

    public void ingredient5() {
        LOG.info("Pepper");
    }

    public void ingredient6() {
        LOG.info("Basil");
    }

    public void prise() {
        LOG.info("total price: " + price);
    }
}
