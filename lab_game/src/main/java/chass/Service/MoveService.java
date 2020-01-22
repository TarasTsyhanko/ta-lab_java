package chass.Service;

import chass.Board;
import chass.box.Coler;
import chass.box.Figura;

import java.util.Scanner;

public class MoveService {
    public Board board;
    private boolean whiteMove = true;

    public MoveService() {
        board = new Board();
    }

    public void chooseFigure() {
        System.out.print("Please, select " + getColor(whiteMove) + " piece: ");
        int hor;
        int vert;
        Figura str;
        while (true) {
            String s = inputString();
            if (isPosition(s) && turnWhiteOrBlack(whiteMove, s)) {
                try {
                    hor = board.getHoryxontal(s);
                    vert = board.getVertycal(s);
                    str = board.getFigura(hor, vert);
                    System.out.println("You`ve chosen " + getColor(!whiteMove) + " " + str.getClass().getSimpleName());
                } catch (NullPointerException e) {
                    System.out.println("There is not figure, select correct position");
                    continue;
                }
                chooseNextPisotion(hor, vert);
                return;
            }
            System.out.println("It position has now figure !");
        }
    }


    private void chooseNextPisotion(int hor1, int vert1) {
        System.out.print("Please, select where you want to move: ");
        while (true) {
            String s = inputString();
            if (isPosition(s)) {
                int hor2 = board.getHoryxontal(s);
                int vert2 = board.getVertycal(s);
                System.out.println("You`ve chosen position : " + s + "   ");
                try {
                    if (board.getFigura(hor1, vert1).getColer().equals(board.getFigura(hor2, vert2).getColer())) {
                        System.out.println("Bad way ! Try again...");
                        continue;
                    }
                } catch (NullPointerException e) {

                }
                writePosition(hor1, vert1, hor2, vert2);
                break;
            }
            System.out.println("Select correct position !");
        }
    }

    public boolean isPosition(String position) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Board.position[i][j].equals(position)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String inputString() {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        return s;
    }

    public void writePosition(int hor1, int vert1, int hor2, int vert2) {
        board.setField(hor2, vert2, board.getFigura(hor1, vert1));
        board.setField(hor1, vert1, null);
    }

    private boolean turnWhiteOrBlack(boolean white, String pos) {
        if (white && board.getFigura(board.getHoryxontal(pos), board.getVertycal(pos)).getColer().equals(Coler.WHITE)) {
            whiteMove = false;
            return true;
        } else if (!white && board.getFigura(board.getHoryxontal(pos), board.getVertycal(pos)).getColer().equals(Coler.BLACK)) {
            whiteMove = true;
            return true;
        }
        return false;
    }

    private String getColor(boolean bol) {
        if (bol) {
            return Coler.WHITE.toString();
        }
        return Coler.BLACK.toString();
    }
}
