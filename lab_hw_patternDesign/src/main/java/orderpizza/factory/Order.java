package orderpizza.factory;

import orderpizza.PizzaType;
import orderpizza.pizza.Pizza;

public interface Order {
    public abstract Pizza orderPizza(PizzaType type);

    public abstract Pizza assemble(PizzaType type);
}
