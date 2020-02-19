package serialization.conteiner;

import serialization.model.Droid;

import java.io.Serializable;

public class Ship<T extends Droid> implements Serializable {
    private Object[] array = new Object[10];
    private int size = 0;

    public boolean put(T type) {
        try {
            if (array.length == size) {
               growArray();
            }
            array[size] = type;
            ++size;
            return true;
        } catch (ClassCastException var3) {
            var3.printStackTrace();
            return false;
        }
    }
    private void growArray(){
            Object[] array1 = array;
            array = new Object[array1.length * 2];
            System.arraycopy(array1, 0, array, 0, array1.length);
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
