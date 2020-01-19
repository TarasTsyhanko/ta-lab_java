package tic_tac_toe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Actions {
    protected int markX() {
        System.out.println("Please mark X : ");
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                int n = scan.nextInt();
                if (n >= 0 && n < Field.gameField.length && Field.gameField[n] == 0) {
                    return n;
                }
                System.out.println("Please enter free number : ");
            } catch (NumberFormatException e) {
            } catch (InputMismatchException e) {
                System.out.println("Please enter the number");
            }
        }
    }

    protected int markO() {
        System.out.println("Please mark O : ");
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                int n = scan.nextInt();
                if (n >= 0 && n < Field.gameField.length && Field.gameField[n] == 0) {
                    return n;
                }
                System.out.println("Please enter free number : ");
            } catch (NumberFormatException e) {
            } catch (InputMismatchException e) {
                System.out.println("Please enter the number");
            }
        }
    }
    protected void turnFirstPlayer(int X) {
        Field.gameField[X] = 1;
    }

    protected void turnSecondplayer(int O) {
        Field.gameField[O] = 2;
    }
}
