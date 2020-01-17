package game.tic.tac.toe;

public class Field {
    public static int[] gameField = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    protected void createGameField() {
        System.out.println("     |     |     ");
        for (int i = 0; i < gameField.length; i++) {
            if (i != 0) {
                if (i == 3 || i == 6) {
                    System.out.println();
                    System.out.println("_____|_____|_____");
                    System.out.println("     |     |     ");
                } else System.out.print("|");
            }

            if (gameField[i] == 0) {
                System.out.print("  " + i + "  ");
            }
            if (gameField[i] == 1) {
                System.out.print("  X  ");
            }
            if (gameField[i] == 2) {
                System.out.print("  O  ");
            }
        }
        System.out.println();
        System.out.println("     |     |     ");
    }

}
