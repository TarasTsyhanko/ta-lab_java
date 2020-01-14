package hw.OOP.hypermarcet.base;

import hw.OOP.hypermarcet.departmentofgoods.Product;

import java.util.ArrayList;

public class Hypermacret {
    public Employee employee;
    public Custumer custumer;
    public ArrayList<Product> products = new ArrayList<Product>();

    public Hypermacret() {
        employee = new Employee();
        custumer = new Custumer();
    }
}
