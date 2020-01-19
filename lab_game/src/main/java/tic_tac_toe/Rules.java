package tic_tac_toe;

public class Rules {
    protected boolean isGameOver() {
        for (int i = 0; i <= 6; i = i + 3) {
            if (Field.gameField[i] == Field.gameField[i + 1] && Field.gameField[i + 1] == Field.gameField[i + 2] && Field.gameField[i] != 0) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (Field.gameField[i] == Field.gameField[i + 3] && Field.gameField[i + 3] == Field.gameField[i + 6] && Field.gameField[i] != 0) {
                return true;
            }
        }
        if (Field.gameField[0] == Field.gameField[4] && Field.gameField[4] == Field.gameField[8] && Field.gameField[0] != 0) {
            return true;
        }
        if (Field.gameField[2] == Field.gameField[4] && Field.gameField[4] == Field.gameField[6] && Field.gameField[2] != 0) {
            return true;
        }
        return false;
    }
    protected boolean isDraw(){
        for (int n: Field.gameField) {
            if (n==0) return false;
        }
        return true;
    }
}
