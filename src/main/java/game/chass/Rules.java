package game.chass;

import static game.chass.Play.combination;
import static game.chass.Play.gameField;

public class Rules {
    //Play p = new Play();

    public boolean isMoveCorrect(String first, String second) {
        if (gameField[takeLoopPosition(first)] > 0 && gameField[takeLoopPosition(first)] < 7) {
            if (gameField[takeLoopPosition(second)] < 1 && gameField[takeLoopPosition(second)] > -8) {
                return true;
            }
        } else if (gameField[takeLoopPosition(first)] > -7 && gameField[takeLoopPosition(first)] < 0) {
            if (gameField[takeLoopPosition(second)] < 7 && gameField[takeLoopPosition(second)] > -1 || gameField[takeLoopPosition(second)] == -7) {
                return true;
            }
        }
        return false;
    }

    public boolean isPosition(String position) {
        for (String s : combination) {
            if (s.equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFigura(String position) {
        if ((gameField[takeLoopPosition(position)] == 0) || (gameField[takeLoopPosition(position)] == -7)) {
            return false;
        }
        return true;
    }

    private int takeLoopPosition(String strPos) {
        return Play.map.get(strPos);
    }
    public void writePosition(String first, String second){
        gameField[takeLoopPosition(second)] = gameField[takeLoopPosition(first)];
        gameField[takeLoopPosition(first)] = getCube(takeLoopPosition(first));
    }
    private int getCube(int pos){
        if(Play.srat[pos]==-7){
            return -7;
        }else {
            return 0;
        }
    }
    public boolean isWhitePlayerWin(){
        for (int n:gameField) {
            if ( !(n < 2) ){
                return false;
            }
        }
        System.out.println("White WIN !!!");
        return true;
    }
    public boolean isBlackPlayerWin(){
        for (int n:gameField) {
            if ( !(n > -1) ){
                return false;
            }
        }
        System.out.println("Black WIN !!!");
        return true;
    }
}
