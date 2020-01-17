package game.chass;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Play {
    public Rules rules = new Rules();
    public Visualization visualization = new Visualization();
    public static Map<String, Integer> map;
    public static int[] gameField = {4, 3, 2, 6, 5, 2, 3, 4,
            1, 1, 1, 1, 1, 1, 1, 1,
            -7, 0, -7, 0, -7, 0, -7, 0,
            0, -7, 0, -7, 0, -7, 0, -7,
            -7, 0, -7, 0, -7, 0, -7, 0,
            0, -7, 0, -7, 0, -7, 0, -7,
            -1, -1, -1, -1, -1, -1, -1, -1,
            -4, -3, -2, -5, -6, -2, -3, -4};
    public static final int[] srat = {-7, 0, -7, 0, -7, 0, -7, 0,
            0, -7, 0, -7, 0, -7, 0, -7,
            -7, 0, -7, 0, -7, 0, -7, 0,
            0, -7, 0, -7, 0, -7, 0, -7,
            -7, 0, -7, 0, -7, 0, -7, 0,
            0, -7, 0, -7, 0, -7, 0, -7,
            -7, 0, -7, 0, -7, 0, -7, 0,
            0, -7, 0, -7, 0, -7, 0, -7,};

    public static String[] combination = {"1A", "1B", "1C", "1D", "1E", "1F", "1G", "1H",
            "2A", "2B", "2C", "2D", "2E", "2F", "2G", "2H",
            "3A", "3B", "3C", "3D", "3E", "3F", "3G", "3H",
            "4A", "4B", "4C", "4D", "4E", "4F", "4G", "4H",
            "5A", "5B", "5C", "5D", "5E", "5F", "5G", "5H",
            "6A", "6B", "6C", "6D", "6E", "6F", "6G", "6H",
            "7A", "7B", "7C", "7D", "7E", "7F", "7G", "7H",
            "8A", "8B", "8C", "8D", "8E", "8F", "8G", "8H"};

    private static int white = 1;
    private static int blakc = 2;
    private static int whiteQuene = -1;
    private static int blackQuene = -2;

    public void mapca() {
        map = new HashMap<String, Integer>();
        for (int i = 0; i < combination.length; i++) {
            map.put(combination[i], i);
        }
    }

    public void makeMove() {
        chooseFigure();

    }

    private void chooseFigure() {
        System.out.print("Please, choose figure: ");
        while (true) {
            String s = inputString();
            if (rules.isPosition(s)) {
                System.out.print("You choose : " + s + "   ");
                if (rules.isFigura(s)) {
                    visualization.whichFigure(s);
                    chooseNextPisotion(s);
                    return;
                }
                System.out.println("It position has now figure !");
            }
            System.out.println("Choose correct position !");
        }

    }

    private void chooseNextPisotion(String firstPosition) {
        System.out.print("Please, choose where you want to move: ");
        while (true) {
            String s = inputString();
            if (rules.isPosition(s)) {
                System.out.println("You choose position : " + s + "   ");
                if (rules.isMoveCorrect(firstPosition, s)) {
                    rules.writePosition(firstPosition, s);
                    return;
                }
                System.out.println("Bad way !");
            }
            System.out.println("Choose correct position !");
        }
    }

    public String inputString() {
        Scanner scan = new Scanner(System.in);
        String s =scan.nextLine();
        return s;
    }
}

class Main2 {
    public static void main(String[] args) {
        Play play = new Play();
        while (true) {
            play.mapca();
            play.visualization.createGameField();
            play.makeMove();
            if (play.rules.isBlackPlayerWin()){
                return;
            }
            if (play.rules.isWhitePlayerWin()){
                return;
            }

            play.mapca();
            play.visualization.createGameField();

        }
    }
}
//♙ ♘ ♗ ♖ ♕ ♔
//♟ ♞ ♝ ♜ ♛ ♚