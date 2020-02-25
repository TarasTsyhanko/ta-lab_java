package orderpizza.pizza.dnipro;

import orderpizza.pizza.DniproPizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PepperoniPizza  extends DniproPizza {
    private static final Logger LOG = LogManager.getLogger(PepperoniPizza.class);
    private int price = 112;

    public PepperoniPizza() {
        LOG.info("Your order: PepperoniPizza");
    }

    public void diameter() {
        LOG.info("Pizza diameter 38 cm");
    }

    public void ingredient1() {
        LOG.info("Pepper");
    }

    public void ingredient2() {
        LOG.info("Royal cheese");
    }

    public void ingredient3() {
        LOG.info("Sausage");
    }

    public void ingredient4() {
        LOG.info("Mushrooms");
    }

    public void ingredient5() {
        LOG.info("Tomato sauce");
    }

    public void prise() {
        LOG.info("total price: "+price);
    }
}
