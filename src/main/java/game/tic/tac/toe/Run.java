package game.tic.tac.toe;

public class Run {

    public static void main(String[] args) {
        Game play = new Game();
        while (true) {
            play.field.createGameField();
            play.actions.turnFirstPlayer(play.actions.markX());
            play.field.createGameField();
            if (play.rules.isGameOver()) {
                System.out.println("X win !");
                return;
            }
            if (play.rules.isDraw()) {
                System.out.println("Draw 1");
                return;
            }
            play.actions.turnSecondplayer(play.actions.markO());
            if (play.rules.isGameOver()) {
                System.out.println(" O win !");
                return;
            }
        }


    }
}
