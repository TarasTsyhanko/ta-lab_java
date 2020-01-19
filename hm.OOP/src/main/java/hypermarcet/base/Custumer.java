package hypermarcet.base;

import hw.OOP.hypermarcet.departmentofgoods.*;
import hypermarcet.departmentofgoods.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Custumer {
    public ArrayList<Product> searchAllProductForLowPrice(ArrayList<Product> products, int exxpectedPrice) {
        ArrayList<Product> someProduct = new ArrayList<Product>();
        for (Product product1 : products) {
            if (product1.getPrice() < exxpectedPrice) {
                someProduct.add(product1);
            }
        }
        return someProduct;
    }

    public int choosePrice() {
        System.out.println("Please choose maximaze price for goods: ");
        Scanner scan = new Scanner(System.in);
        int maxPrice = scan.nextInt();
        return maxPrice;
    }

    public void lookAtList(Product product) {
        System.out.println("Product: " + product.getClass().getSimpleName() + " number " + product.getNumber() + " with PRICE: " + product.getPrice());
    }

    public int chooseTypeOfGoods() {
        System.out.println("Please choose type of goods : ");
        System.out.println("Press 1 -  Plumbimg, 2 - WoodProduct, 3 - PaintAndVarnish, 4 - ElectronicDevice ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public String getTypeOfGoods(int number) {
        if (number == 1) {
            return Plumbing.class.getSimpleName();
        } else if (number == 2) {
            return WoodProduct.class.getSimpleName();
        } else if (number == 3) {
            return PaintAndVarnish.class.getSimpleName();
        } else if (number == 4) {
            return ElectricDevice.class.getSimpleName();
        }

        return " ";
    }
}
