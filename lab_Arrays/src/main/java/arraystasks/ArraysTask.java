package arraystasks;

public class ArraysTask {
    public static int[] sameElementArray(int[] array1, int[] array2) {
        array1 = uniqueArray(array1);
        array2 = uniqueArray(array2);
        int n = 0;
        int[] array3 = new int[sameElements(array1, array2)];
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    array3[n] = array1[i];
                    n++;
                    break;
                }
            }
        }
        return array3;
    }

    public static int[] differentElementArray(int[] arrayA, int[] arrayB) {
        int n = 0;
        int[] sameArray = sameElementArray(arrayA, arrayB);
        arrayA = uniqueArray(arrayA);
        arrayB = uniqueArray(arrayB);
        int[] array3 = new int[arrayA.length + arrayB.length - sameArray.length];
        for (int i = 0; i < arrayA.length; i++) {
            if (isElementInArray(sameArray, arrayA[i])) {
                array3[n] = arrayA[i];
                n++;
            }
        }
        for (int i = 0; i < arrayB.length; i++) {
            if (isElementInArray(sameArray, arrayB[i])) {
                array3[n] = arrayB[i];
                n++;
            }
        }
        if (n != array3.length) {
            int[] arr = new int[n];
            System.arraycopy(array3, 0, arr, 0, n);
            array3 = arr;
        }
        return array3;
    }

    private static int sameElements(int[] array1, int[] array2) {
        int n = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    n++;
                    break;
                }
            }
        }
        return n;
    }

    private static boolean isElementInArray(int[] array, int i) {
        for (int j = 0; j < array.length; j++) {
            if (array[j] == i) {
                return false;
            }
        }
        return true;
    }

    public static int[] uniqueArray(int[] array) {
        int len = array.length;
        for (int i = 0, m = 0; i != len; i++, len = m) {
            for (int j = m = i + 1; j != len; j++) {
                if (array[j] != array[i]) {
                    if (m != j) {
                        array[m] = array[j];
                    }
                    m++;
                }
            }
        }
        if (len != array.length) {
            int[] array1 = new int[len];
            System.arraycopy(array, 0, array1, 0, len);
            array = array1;
        }
        return array;
    }

    public static int[] serialArray(int[] array) {
        int[] array2 = new int[100];
        array2[0] = array[0];
        int n = 0;
        int b = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = b; j < array.length; j++) {
                if (n == i) {
                    if (array2[n] != array[j]) {
                        array2[n + 1] = array[j];
                        n++;
                        b = j;
                    }
                } else break;
            }
        }
        n++;
        if (n != array.length) {
            int[] array1 = new int[n];
            System.arraycopy(array2, 0, array1, 0, n);
            array2 = array1;
        }
        return array2;
    }
}
