package comperreaderwritter;

import static constant.Constants.*;

public class Times {
    public static long takeTime1() {
        long start1 = System.nanoTime();
        String s = Readers.readFileByBuffer(FILE_PATH_FOR_READ);
        Readers.writeFileByBuffer(s, FILE_PATH_FOR_WRITE_BY_BUFFER);
        long end1 = System.nanoTime() - start1;
        return end1/1000000;
    }

    public static long takeTime2() {
        long start1 = System.nanoTime();
        String s = Readers.readFileByStream(FILE_PATH_FOR_READ);
        Readers.writeFileByStream(s, FILE_PATH_FOR_WRITE_BY_STREAM);
        long end1 = System.nanoTime() - start1;
        return end1/1000000;
    }

    public static long takeTime3() {
        long start1 = System.nanoTime();
        String s = Readers.readFileJustByReader(FILE_PATH_FOR_READ);
        Readers.writeFileJustByWriter(s, FILE_PATH_FOR_WRITE_JUST_WRITER);
        long end1 = System.nanoTime() - start1;
        return end1/1000000;
    }

    public static long takeTime4() {
        long start1 = System.nanoTime();
        String s = Readers.readFileByScanner(FILE_PATH_FOR_READ);
        Readers.writeTextByPrintWriter(s, FILE_PATH_FOR_WRITE_BY_PRINT_WR);
        long end1 = System.nanoTime() - start1;
        return end1/1000000;
    }

}
