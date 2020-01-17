package game.tic.tac.toe;

import static game.tic.tac.toe.Field.gameField;

public class Rules {
    protected boolean isGameOver() {
        for (int i = 0; i <= 6; i = i + 3) {
            if (gameField[i] == gameField[i + 1] && gameField[i + 1] == gameField[i + 2] && gameField[i] != 0) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gameField[i] == gameField[i + 3] && gameField[i + 3] == gameField[i + 6] && gameField[i] != 0) {
                return true;
            }
        }
        if (gameField[0] == gameField[4] && gameField[4] == gameField[8] && gameField[0] != 0) {
            return true;
        }
        if (gameField[2] == gameField[4] && gameField[4] == gameField[6] && gameField[2] != 0) {
            return true;
        }
        return false;
    }
    protected boolean isDraw(){
        for (int n:gameField) {
            if (n==0) return false;
        }
        return true;
    }
}
