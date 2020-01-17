package task.second;

public class Plants {
    private int size;
    public Color color;
    private Type type;

    public Plants(int size, String color, String type) throws ColorException, TypeException {
        this.size = size;
        Color[]colors = Color.values();
        for (int i = 0; i < colors.length; i++) {
            if ( color.equals(colors[i].toString()) ) {
                this.color = colors[i];
                break;
            }else if (i == colors.length-1){
                throw new ColorException("Bad coler",color);
            }
        }
        Type[] types = Type.values();
        for (int i = 0; i < types.length; i++) {
            if ( type.equals(types[i].toString()) ) {
                this.type = types[i];
                break;
            }else if (i == types.length-1){
                throw new TypeException("Bad type");
            }
        }

    }

    public Plants() {
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
