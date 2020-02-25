package orderpizza.factory.impl;

import orderpizza.PizzaType;
import orderpizza.factory.Order;
import orderpizza.pizza.KyivPizza;
import orderpizza.pizza.Pizza;
import orderpizza.pizza.kyiv.CheesePizza;
import orderpizza.pizza.kyiv.ClamPizza;
import orderpizza.pizza.kyiv.PepperoniPizza;
import orderpizza.pizza.kyiv.VeggiePizza;

public class KyivOrder implements Order {
    @Override
    public Pizza orderPizza(PizzaType type) {
        KyivPizza pizza = null;
        if (type == PizzaType.CHEESE){
            pizza = new CheesePizza();
        }else if (type == PizzaType.CLAM){
            pizza = new ClamPizza();
        }else if (type == PizzaType.PEPPERONI){
            pizza = new PepperoniPizza();
        }else if (type == PizzaType.VEGGIE){
            pizza = new VeggiePizza();
        }
        return pizza;
    }
    public Pizza assemble(PizzaType type) {
        KyivPizza pizza = (KyivPizza) orderPizza(type);
        pizza.diameter();
        pizza.ingredient1();
        pizza.ingredient2();
        pizza.ingredient3();
        pizza.ingredient4();
        pizza.ingredient5();
        pizza.ingredient6();
        pizza.prise();
        return pizza;
    }
}
