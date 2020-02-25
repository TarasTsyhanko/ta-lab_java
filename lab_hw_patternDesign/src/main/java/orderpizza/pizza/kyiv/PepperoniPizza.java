package orderpizza.pizza.kyiv;

import orderpizza.pizza.KyivPizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PepperoniPizza extends KyivPizza {
    private static final Logger LOG = LogManager.getLogger(PepperoniPizza.class);
    private int price = 105;

    public PepperoniPizza() {
        LOG.info("Your order: PepperoniPizza");
    }

    public void diameter() {
        LOG.info("Pizza diameter 30 cm");
    }

    public void ingredient1() {
        LOG.info("Pepper");
    }

    public void ingredient2() {
        LOG.info("Royal cheese");
    }

    public void ingredient3() {
        LOG.info("Salami");
    }

    public void ingredient4() {
        LOG.info("Mushrooms");
    }

    public void ingredient5() {
        LOG.info("Tomato sauce");
    }

    public void ingredient6() {
        LOG.info("Mozzarella");
    }

    public void prise() {
        LOG.info("total price: " + price);
    }
}