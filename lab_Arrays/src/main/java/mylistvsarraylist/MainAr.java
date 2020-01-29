package mylistvsarraylist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MainAr {
    private static final Logger logger = LogManager.getLogger(MainAr.class);

    public static void main(String[] args) {
        TestList test = new TestList();
        List<String> list = new ArrayList<>();
        ArrayString list2 = new ArrayString();

        long i = test.testList(list2);
        long j = test.testArrayList(list);

        logger.info("ArrayList time " + j / 1000000 + " - milliseconds");
        logger.info("MyList time " + i / 1000000 + " - milliseconds");
    }
}
