package game.NEW.box;

public abstract class Figura {
    public String figura;
    public Coler coler ;

    public String getFigura() {
        return figura;
    }

    @Override
    public String toString() {
        return figura;
    }
}
