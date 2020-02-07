package arraystasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        CreateArray create = new CreateArray();

        int[] arrayFirst = create.getNewArray();
        int[] arraySecond = create.getNewArray();
        logger.info(Arrays.toString(arrayFirst));
        logger.info(Arrays.toString(arraySecond));

        int[] array1 = ArraysTask.sameElementArray(arrayFirst, arraySecond);
        logger.info(Arrays.toString(array1));
        int[] array2 = ArraysTask.differentElementArray(arrayFirst, arraySecond);
        logger.info(Arrays.toString(array2));
        int[] array3 = ArraysTask.uniqueArray(arraySecond);
        logger.info(Arrays.toString(array3));

        int[] arrayThree = create.getNewArray();
        logger.info(Arrays.toString(arrayThree));
        int[] array4 = ArraysTask.serialArray(arrayThree);
        logger.info(Arrays.toString(array4));

    }
}