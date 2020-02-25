package orderpizza.pizza.lviv;

import orderpizza.pizza.LvivPizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VeggiePizza extends LvivPizza {
    private static final Logger LOG = LogManager.getLogger(VeggiePizza.class);
    private int price = 85;

    public VeggiePizza() {
        LOG.info("Your order: VeggiePizza");
    }

    public void diameter() {
        LOG.info("Pizza diameter 35 cm");
    }

    public void ingredient1() {
        LOG.info("Pesto");
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

    public void ingredient7() {
        LOG.info("Carrot");
    }

    public void prise() {
        LOG.info("total price: " + price);
    }
}
