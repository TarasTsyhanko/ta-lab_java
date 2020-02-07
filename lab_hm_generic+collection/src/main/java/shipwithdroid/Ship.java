package shipwithdroid;

public class Ship<T extends Droid & Comparable<Droid>> {
    private Object[] array = new Object[10];
    private int size = 0;

    public boolean put(T type) {
        try {
            if (array.length == size) {
                Object[] arra1 = array;
                array = new Object[arra1.length * 2];
                System.arraycopy(arra1, 0, array, 0, arra1.length);
            }
            array[size] = type;
            ++size;
            return true;
        } catch (ClassCastException var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public Droid get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (Droid) array[index];
    }

    public boolean remove(int index) {
        if (size <= index) {
            throw new IndexOutOfBoundsException();
        }
        if (size == index + 1) {
            --size;
            return true;
        }
        System.arraycopy(array, index + 1, array, index, array.length);
        --size;
        return true;
    }

    public int size() {
        return this.size;
    }
}
