package task.model;

public enum Carry {
    CLOSE("0-500 m"),
    MIDDLE("500 - 1000 m"),
    FAR(">1000 m");
    String s;

    Carry(String s) {
    }

    public String getS() {
        return s;
    }
}
