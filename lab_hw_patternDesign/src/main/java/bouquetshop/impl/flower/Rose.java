package bouquetshop.impl.flower;

public class Rose {
    private int price;
    private Color color;

    public Rose(Color color) {
        this.color = color;
        if (color == Color.PINK) price = 35;
        if (color == Color.RED) price = 40;
        if (color == Color.WHITE) price = 30;
    }

    public int getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }
}
