package orderpizza;

import orderpizza.factory.Order;
import orderpizza.factory.impl.KyivOrder;
import orderpizza.factory.impl.LvivOrder;
import orderpizza.pizza.Pizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {
    private static final Logger LOG = LogManager.getLogger(Client.class);

    public static void main(String[] args) {
        Order order = new LvivOrder();
        Pizza pizza = order.assemble(PizzaType.CHEESE);
        LOG.info("-------------------------------");
        Order order2 = new KyivOrder();
        Pizza pizza2 = order2.assemble(PizzaType.CHEESE);

    }
}
