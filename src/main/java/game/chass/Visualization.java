package game.chass;


import static game.chass.Play.gameField;
import static game.chass.Play.map;

public class Visualization {


    public void createGameField() {
        int pos = 0;
        int s1 = 1;
        int s2 = 2;
        upFeild();
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                createWhiteBlackLine();
                System.out.print("□|");
                for (int k = 0; k < 4; k++) {
                    whiteField(pos);
                    blackField(pos+1);
                    pos = pos +2;
                    if (k == 3) {
                        System.out.println("❑ " + s1);
                    }
                }
                createWhiteBlackLine();
            } else {
                createBlackeWhiteLine();
                System.out.print("□|");
                for (int k = 0; k < 4; k++) {
                    blackField(pos);
                    whiteField(pos+1);
                    pos = pos+2;
                    if (k == 3) {
                        System.out.println("❑ " + s2);
                    }
                }
                createBlackeWhiteLine();
                s1 = s1 + 2;
                s2 = s2 + 2;
            }
        }
        upFeild();
        System.out.println("    A     B     C     D     E     F    G     H");
    }
    private void upFeild() {
        System.out.println("❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑");
    }

    private void createWhiteBlackLine() {
        System.out.println("□|███|░░░|███|░░░|███|░░░|███|░░░|❑ ");
    }

    private void createBlackeWhiteLine() {
        System.out.println("□|░░░|███|░░░|███|░░░|███|░░░|███|❑ ");
    }

    private void whiteField(int position) {
        //p =new Play();
        System.out.print("█" + getImageFigure(position) + "█|");
    }

    private void blackField(int position) {
        //p =new Play();
        System.out.print("░" + getImageFigure(position) + "░|");
    }
    protected void whichFigure(String position){
        int number = gameField[map.get(position)];
        yourFigure(number);
    }
    private String getImageFigure(int position) {
        if (gameField[position] == 1) {
            return "♙";
        } else if (gameField[position] == 2) {
            return "♗";
        } else if (gameField[position] == 3) {
            return "♘";
        } else if (gameField[position] == 4) {
            return "♖";
        } else if (gameField[position] == 5) {
            return "♕";
        } else if (gameField[position] == 6) {
            return "♔";
        } else if (gameField[position] == -1) {
            return "♟";
        } else if (gameField[position] == -2) {
            return "♝";
        } else if (gameField[position] == -3) {
            return "♞";
        } else if (gameField[position] == -4) {
            return "♜";
        } else if (gameField[position] == -5) {
            return "♛";
        } else if (gameField[position] == -6) {
            return "♚";
        } else if (gameField[position] == -7) {
            return "█";
        } else return "░";
    }
    private void yourFigure(int num){
        System.out.print("You choce : ");
        String s = "";
        if (num == 1) {
            s = "♙ - black Pawn";
        } else if (num == 2) {
            s = "♗ - black Officer";
        } else if (num == 3) {
            s = "♘ - black Horse";
        } else if (num == 4) {
            s = "♖ - black Tour";
        } else if (num == 5) {
            s = "♕ - black Queen";
        } else if (num == 6) {
            s = "♔ - black King";
        } else if (num == -1) {
            s = "♟ - white Pawn";
        } else if (num == -2) {
            s = "♝ - white Officer";
        } else if (num == -3) {
            s = "♞ - white Horse";
        } else if (num == -4) {
            s = "♜ - white Tour";
        } else if (num == -5) {
            s = "♛ - white Queen";
        } else if (num == -6) {
            s = "♚ - white King";
        }
        System.out.println(s);
    }
}
