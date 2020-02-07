package mylistvsarraylist;

public class ArrayString {
    private String[] str = new String[0];
    private int size = 0;

    public boolean add(String string) {
        if (size == str.length) {
            String[] str2 = new String[(str.length + 5) * 2];
            System.arraycopy(str, 0, str2, 0, size);
            str = str2;
        }
        str[size] = string;
        size++;
        return true;
    }

    public boolean addIndex(int index, String string) {
        if (size == str.length) {
            String[] str2 = new String[(str.length + 5) * 2];
            System.arraycopy(str, 0, str2, 0, size);
            str = str2;
        }

            System.arraycopy(str, index, str, index + 1, size - index);
            str[index] = string;
        size++;
        return true;
    }

    public String get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return str[index];
    }

    public int size() {
        return size;
    }
}
