package chass.Service;

public class VisualService {
    public MoveService move;

    public VisualService() {
        move = new MoveService();
    }

    public void createGameField() {
        System.out.println("    A     B     C     D     E     F    G     H");
        boardLine();
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                createWhire(i);
            } else {
                createBlack(i);
            }
        }
        boardLine();
    }
    private void createWhire(int i) {
        createWhiteBlackLine();
        System.out.print("□|");
        for (int k = 0; k < 8; k++) {
            whiteField(i,k);
            k++;
            blackField(i,k);
        }
        System.out.println("❑ " + (i+1));
        createWhiteBlackLine();
    }
     private void  createBlack(int i){
         createBlackeWhiteLine();
         System.out.print("□|");
         for (int k = 0; k < 8; k++) {
             blackField(i,k);
             k++;
             whiteField(i,k);
         }
         System.out.println("❑ " + (i+1));
         createBlackeWhiteLine();
    }

    private void boardLine() {
        System.out.println("❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑❑");
    }

    private void createWhiteBlackLine() {
        System.out.println("□|███|░░░|███|░░░|███|░░░|███|░░░|❑ ");
    }

    private void createBlackeWhiteLine() {
        System.out.println("□|░░░|███|░░░|███|░░░|███|░░░|███|❑ ");
    }

    private void whiteField(int i, int k) {
        String s;
        try {
            s = move.board.getFigura(i, k).getImage();
        } catch (NullPointerException e) {
            s = "█";
        }
        System.out.print("█" + s + "█|");
    }

    private void blackField(int i, int k) {
        String s;
        try {
            s = move.board.getFigura(i, k).getImage();
        } catch (NullPointerException e) {
            s = "░";
        }
        System.out.print("░" + s + "░|");
    }
}
