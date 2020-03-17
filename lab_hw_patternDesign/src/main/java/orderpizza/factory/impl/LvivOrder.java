package orderpizza.factory.impl;

import orderpizza.PizzaType;
import orderpizza.factory.Order;
import orderpizza.pizza.LvivPizza;
import orderpizza.pizza.Pizza;
import orderpizza.pizza.lviv.CheesePizza;
import orderpizza.pizza.lviv.ClamPizza;
import orderpizza.pizza.lviv.PepperoniPizza;
import orderpizza.pizza.lviv.VeggiePizza;

public class LvivOrder implements Order {
    @Override
    public Pizza orderPizza(PizzaType type) {
        LvivPizza pizza = null;
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
        LvivPizza pizza = (LvivPizza)orderPizza(type);
        pizza.diameter();
        pizza.ingredient1();
        pizza.ingredient2();
        pizza.ingredient3();
        pizza.ingredient4();
        pizza.ingredient5();
        pizza.ingredient6();
        pizza.ingredient7();
        pizza.prise();
        return pizza;
    }
}
