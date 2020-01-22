package hypermarcet;


import hypermarcet.base.Hypermacret;
import hypermarcet.departmentofgoods.Product;
import hypermarcet.goods.*;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Hypermacret marcet = new Hypermacret(); //create hypermarcet with shelf

        marcet.products.add(new Bath(1, 3000));  //filling the shelves with goods
        marcet.products.add(new Bath(2, 3500));
        marcet.products.add(new Bowl(1, 2800));
        marcet.products.add(new Bowl(2, 2000));
        marcet.products.add(new Washbasin(1, 2100));
        marcet.products.add(new Washbasin(2, 3800));
        marcet.products.add(new Dor(1, 1900));
        marcet.products.add(new Dor(2, 2640));
        marcet.products.add(new Bed(1, 1000));
        marcet.products.add(new Bed(2, 1650));
        marcet.products.add(new Laminate(1, 3290));
        marcet.products.add(new Laminate(2, 2800));
        marcet.products.add(new Paint(1, 350));
        marcet.products.add(new Paint(2, 640));
        marcet.products.add(new Varnish(1, 400));
        marcet.products.add(new Varnish(2, 500));
        marcet.products.add(new VashingMachine(1, 3500));
        marcet.products.add(new VashingMachine(2, 4800));

        ArrayList<Product> specialProduct = new ArrayList<Product>();
        specialProduct.addAll(marcet.custumer.searchAllProductForLowPrice(marcet.products, marcet.custumer.choosePrice()));
        for (Product list : specialProduct) {
            marcet.custumer.lookAtList(list);
        }
        System.out.println("-------------------------------------------");

        int number = marcet.custumer.chooseTypeOfGoods();
        for (Product product : marcet.products) {
            if (marcet.custumer.getTypeOfGoods(number).equals(product.getClass().getSuperclass().getSimpleName())) {
                marcet.custumer.lookAtList(product);
            }
        }
        Collections.sort(marcet.products, marcet.employee.comparator);
        for (Product product : marcet.products) {
            marcet.custumer.lookAtList(product);
        }
    }
}
