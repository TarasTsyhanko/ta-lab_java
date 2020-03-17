package orderpizza.factory.impl;

import orderpizza.PizzaType;
import orderpizza.factory.Order;
import orderpizza.pizza.DniproPizza;
import orderpizza.pizza.Pizza;
import orderpizza.pizza.dnipro.CheesePizza;
import orderpizza.pizza.dnipro.ClamPizza;
import orderpizza.pizza.dnipro.PepperoniPizza;
import orderpizza.pizza.dnipro.VeggiePizza;

public class DniproOrder implements Order {
    @Override
    public Pizza orderPizza(PizzaType type) {
        DniproPizza pizza = null;
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
        Pizza pizza = orderPizza(type);
        pizza.diameter();
        pizza.ingredient1();
        pizza.ingredient2();
        pizza.ingredient3();
        pizza.ingredient4();
        pizza.ingredient5();
        pizza.prise();

        return pizza;
    }
}
