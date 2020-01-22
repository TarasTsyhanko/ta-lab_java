package task.first;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rectangle {
    public int squareRectangle(int a, int b){
        return (a*b);
    }
    public int getNumberFromConsol(){
        Scanner scanner = new Scanner(System.in);
        int i =0;
        try {
            i = scanner.nextInt();
            if (i<0){
                throw new NumberNegativeException("Number negative");
            }
        }catch (InputMismatchException e){
            e.printStackTrace();

        }catch (NumberNegativeException e) {
            System.err.println(e.getMessage());
        }
        return i;
    }
}
