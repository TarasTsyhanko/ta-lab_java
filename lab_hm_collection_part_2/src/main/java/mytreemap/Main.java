package mytreemap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        MyMap<Integer, String> treeMap = new MyTreeMap<Integer, String>();
        treeMap.put(10, "ten");
        treeMap.put(4, null);
        treeMap.put(18, "eighteen");
        treeMap.put(22, "twenty two");
        treeMap.put(1, "one");
        treeMap.put(3, "tree");
        treeMap.put(2, "two");
        treeMap.put(14, "fourteen");
        treeMap.put(15, "fifteen");
        treeMap.put(5, "five");
        treeMap.put(0, "zero");
        log.info(treeMap.firstEntry());
        log.info(treeMap.lastEntry());
        log.info(treeMap.isEmpty());
        log.info(treeMap.size());
        log.info(treeMap.remove(3));
        log.info(treeMap.remove(14));

        Map<Integer, String> map = new TreeMap<>();
        map.put(9, "nine -from MAP");
        map.put(12, "twelve - from MAP");
        map.put(6, "six - from MAP");
        treeMap.addAll(map);

        for (MyTreeMap.Entry<Integer, String> t : treeMap) {
            log.info(t.getValue());
        }
        log.info(treeMap.size());
    }

}
