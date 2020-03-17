package comperreaderwritter;

import constant.MyProperties;

public class Times {
    private static MyProperties p = new MyProperties();
    public static long takeTime1() {
        long start1 = System.nanoTime();
        String s = Readers.readFileByBuffer(p.getProperty("file_for_read"));
        Readers.writeFileByBuffer(s, p.getProperty("file_for_write_by_buffer"));
        long end1 = System.nanoTime() - start1;
        return end1/1000000;
    }

    public static long takeTime2() {
        long start1 = System.nanoTime();
        String s = Readers.readFileByStream(p.getProperty("file_for_read"));
        Readers.writeFileByStream(s, p.getProperty("file_for_write_by_stream"));
        long end1 = System.nanoTime() - start1;
        return end1/1000000;
    }

    public static long takeTime3() {
        long start1 = System.nanoTime();
        String s = Readers.readFileJustByReader(p.getProperty("file_for_read"));
        Readers.writeFileJustByWriter(s, p.getProperty("file_for_write_by_just_writer"));
        long end1 = System.nanoTime() - start1;
        return end1/1000000;
    }

    public static long takeTime4() {
        long start1 = System.nanoTime();
        String s = Readers.readFileByScanner(p.getProperty("file_for_read"));
        Readers.writeTextByPrintWriter(s, p.getProperty("file_for_write_by_print_wr"));
        long end1 = System.nanoTime() - start1;
        return end1/1000000;
    }

}
