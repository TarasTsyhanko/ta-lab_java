import task.first.Rectangle;
import task.second.Exceptions.ColorException;
import task.second.Plants;
import task.second.Exceptions.TypeException;

import java.util.ArrayList;

public class Main {

    private  static Plants plant(int size, String color, String type){

        Plants plants = new Plants();

        try {
            plants = new Plants(size,color,type);
        }catch (ColorException | TypeException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return plants;
    };
    public static void main(String[] args)  {

        Rectangle rectangle = new Rectangle();
        int a = rectangle.getNumberFromConsol();
        int b  =rectangle.getNumberFromConsol();
        System.out.println("Rectangl square will be : " +rectangle.squareRectangle(a, b));


        Plants[] plant = {plant(1, "WHITE", "FLOWER"),
                    plant(2, "BLUE", "BUSH"),
                    plant(3, "RED", "TREE"),
                    plant(4, "BLACK", "GRASS"),
                    plant(5, "RED1", "FRUIT")};

    }
}
