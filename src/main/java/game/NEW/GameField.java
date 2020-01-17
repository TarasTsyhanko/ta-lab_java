package game.NEW;

public class GameField {
    Logic l;

    public GameField() {
        l = new Logic();
    }

    public void createGameField() {
        System.out.println("    A     B     C     D     E     F    G     H");
        int s1 = 1;
        int s2 = 2;
        upFeild();
        for (int i = 0; i < 8; i++) {
            int pos = 0;
            if (i % 2 == 0) {
                createWhiteBlackLine();
                System.out.print("□|");
                for (int k = 0; k < 4; k++) {
                    whiteField(i, pos);
                    blackField(i, pos + 1);
                    pos = pos + 2;
                    if (k == 3) {
                        System.out.println("❑ " + s1);
                    }
                }
                createWhiteBlackLine();
            } else {
                createBlackeWhiteLine();
                System.out.print("□|");
                for (int k = 0; k < 4; k++) {
                    blackField(i, pos);
                    whiteField(i, pos + 1);
                    pos = pos + 2;
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

    private void whiteField(int position, int po) {
        String s;
        try {
            s = l.field[position][po].getFigura();
        } catch (NullPointerException e) {
            s = "█";
        }
        System.out.print("█" + s + "█|");
    }

    private void blackField(int position, int po) {
        String s;
        try {
            s = l.field[position][po].getFigura();
        } catch (NullPointerException e) {
            s = "░";
        }
        System.out.print("░" + s + "░|");
    }




    public static void main(String[] args) {
        GameField j = new GameField();
        j.createGameField();
    }
}
