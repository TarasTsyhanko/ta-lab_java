package comper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static final Logger log = LogManager.getLogger(Math.class);
    public static void main(String[] args) {
        ArrayList<Europa> list = new ArrayList<Europa>();
        list.add(new Europa("Ukraine","Kyiv"));
        list.add(new Europa("Poland","Warsaw"));
        list.add(new Europa("England","London"));
        list.add(new Europa("Spain","Madrid"));
        Collections.sort(list);
        log.info("sort by Comparable, by country");
        for (Europa e:list) {
            log.info(e);
        }
        Collections.sort(list,new ComparatorEurope());
        log.info("sort by Comparator, by capital");
        for (Europa e:list) {
            log.info(e);
        }
        log.info("binarySearch");
        log.info(list.get(Collections.binarySearch(list,
                new Europa("England","  0  "))).getCapital());//by Comparable
        log.info(list.get(Collections.binarySearch(list,
                new Europa("  0  ","Madrid"),new ComparatorEurope())).getCountry());//By Comparator
    }
}
