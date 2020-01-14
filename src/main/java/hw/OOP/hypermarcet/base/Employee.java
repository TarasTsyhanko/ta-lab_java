package hw.OOP.hypermarcet.base;

import hw.OOP.hypermarcet.departmentofgoods.Product;

import java.util.Comparator;

public class Employee {
    public Comparator comparator = new Comparator<Product>() {
        public int compare(Product o1, Product o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };
}
