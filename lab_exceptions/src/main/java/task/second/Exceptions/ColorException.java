package task.second.Exceptions;

public class ColorException extends Exception {
    public String color;

    public ColorException(String message, String color) {
        super(message);
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorException{" +
                "color='" + color + '\'' +
                '}';
    }
}
