package task.second;

public class TypeException extends Exception {
    public String type;
    public TypeException(String message,String type) {
        super(message);
        this.type = type;
    }

    @Override
    public String toString() {
        return "TypeException{" +
                "type='" + type + '\'' +
                '}';
    }
}
