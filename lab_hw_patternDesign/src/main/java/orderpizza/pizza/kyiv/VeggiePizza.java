package orderpizza.pizza.kyiv;

import orderpizza.pizza.KyivPizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VeggiePizza extends KyivPizza {
    private static final Logger LOG = LogManager.getLogger(VeggiePizza.class);
    private int price = 105;

    public VeggiePizza() {
        LOG.info("Your order: VeggiePizza");
    }

    public void diameter() {
        LOG.info("Pizza diameter 30 cm");
    }

    public void ingredient1() {
        LOG.info("Veggie cheese");
    }

    public void ingredient2() {
        LOG.info("Red pepper");
    }

    public void ingredient3() {
        LOG.info("Olives");
    }

    public void ingredient4() {
        LOG.info("Corn");
    }

    public void ingredient5() {
        LOG.info("Tomatoes");
    }

    public void ingredient6() {
        LOG.info("Mushrooms");
    }

    public void prise() {
        LOG.info("total price: " + price);
    }
}
