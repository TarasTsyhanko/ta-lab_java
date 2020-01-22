package chass.box;

public abstract class Figura {
    protected String image;
    protected Coler coler;

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return image;
    }

    public Coler getColer() {
        return coler;
    }

    public void setColer(Coler coler) {
        this.coler = coler;
    }
}
