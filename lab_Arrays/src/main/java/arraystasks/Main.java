package arraystasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        int[] arrayFirst = {1, 1, -1, -1, -1, 1, 1, 4, 4, 4, -7, 3, 15, 8, 6, 0, -4, 10, -5, 5, 5, 5, 9};
        int[] arraySecond = {-5, 6, 6, 7, -3, 20, -11, -9, 9, 1, 0, -10, 4, 4, 20, 0, 0};

        int[] array1 = ArraysTask.sameElementArray(arrayFirst, arraySecond);
        logger.info(Arrays.toString(array1));
        int[] array2 = ArraysTask.differentElementArray(arrayFirst, arraySecond);
        logger.info(Arrays.toString(array2));
        int[] array3 = ArraysTask.uniqueArray(arraySecond);
        logger.info(Arrays.toString(array3));

        int[] arrayThree = {6,6,6,6,6,6,6,7,7,7,1,1,2,2,1,1,3,1,1,4,4,6,7,7,7,7,3,1,2,3,4,5,6,7,7,7,8,8,9,0};
        int[] array4 = ArraysTask.serialArray(arrayThree);
        logger.info(Arrays.toString(array4));

    }
}
//6 7 1 2 1 3 1 4 6 7 3 1 2 3 4 5 6 7 8 9 0