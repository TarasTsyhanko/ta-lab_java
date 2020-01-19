package task.second;

import task.second.Exceptions.ColorException;
import task.second.Exceptions.TypeException;

public class Plants {
    private int size;
    public Color color;
    private Type type;
     public Plants(){

     }

    public Plants(int size, String color, String type) throws ColorException, TypeException {
        this.size = size;
        try {
            this.color = Color.valueOf(color);
        }catch (IllegalArgumentException e){
            throw new ColorException("Incorrect color ",color);
        }
        try {
            this.type = Type.valueOf(type);
        }catch (IllegalArgumentException e){
            throw new TypeException("Incorrect type ",type);
        }
    }

    @Override
    public String toString() {
        return "Plants{" +
                "size=" + size +
                ", color=" + color +
                ", type=" + type +
                '}';
    }
}
