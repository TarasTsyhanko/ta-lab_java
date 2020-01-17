import task.first.Rectangle;
import task.second.ColorException;
import task.second.Plants;
import task.second.TypeException;

public class Main {
    public static void main(String[] args) throws ColorException, TypeException {

        Rectangle rectangle = new Rectangle();
        int a = rectangle.getNumberFromConsol();
        int b  =rectangle.getNumberFromConsol();
        System.out.println("Rectangl square will be : " +rectangle.squareRectangle(a, b));


        Plants[] plant = {new Plants(1, "WHITE", "FLOWER"),
                new Plants(2, "BLUE", "BUSH"),
                new Plants(3, "RED", "TREE"),
                new Plants(4, "BLACK", "GRASS"),
                new Plants(5, "RED", "FRUIT")};

    }
}
