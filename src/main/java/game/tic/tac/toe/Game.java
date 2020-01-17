package game.tic.tac.toe;

public class Game {
    public Field field;
    public Actions actions;
    public Rules rules;
    public Game(){
        field = new Field();
        actions= new Actions();
        rules = new Rules();
    }
}
