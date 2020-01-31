package shipwithdroid;

public class Ship<T extends Droid & Comparable<Droid>> {
    private Object[] array = new Object[10];
    private int size = 0;

    public Ship() {
    }

    public boolean put(T type) {
        try {
            if (this.array.length == this.size) {
                Object[] arra1 = this.array;
                this.array = new Object[arra1.length * 2];
                System.arraycopy(arra1, 0, this.array, 0, arra1.length);
            }

            this.array[this.size] = type;
            ++this.size;
            return true;
        } catch (ClassCastException var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public Droid get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        } else {
            return (Droid)this.array[index];
        }
    }

    public boolean remove(int index) {
        if (this.size <= index) {
            throw new IndexOutOfBoundsException();
        } else if (this.size == index + 1) {
            --this.size;
            return true;
        } else {
            System.arraycopy(this.array, index + 1, this.array, index, this.array.length);
            --this.size;
            return true;
        }
    }

    public int size() {
        return this.size;
    }
}
