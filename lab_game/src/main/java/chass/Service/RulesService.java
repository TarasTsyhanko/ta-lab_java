package chass.Service;

import chass.Service.MoveService;

public class RulesService {

    public boolean isGameOver(MoveService move) {
        int k = 0;
        int h = -1;
        int v = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                try {
                    if (move.board.getFigura(i, j).getClass().getSimpleName().equals("King")) {
                        k++;
                        h = i;
                        v = j;
                    }
                } catch (NullPointerException e) {

                }
            }
        }
        if (k == 1) {
            whoWin(h, v, move);
            return true;
        }
        return false;
    }

    private void whoWin(int hor, int vert, MoveService move) {
        System.out.println(move.board.getFigura(hor, vert).getColer() + " WIN !!");
    }
}
