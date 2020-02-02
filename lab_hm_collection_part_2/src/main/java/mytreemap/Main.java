package mytreemap;

import consolemenu.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        MyTreeMap<Integer, String> treeMap = new MyTreeMap<Integer, String>();
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
        //treeMap.remove(1);
        //treeMap.remove(14);
        //log.info(treeMap.get(5));
        log.info(treeMap.size());

        for (MyTreeMap.Entry<Integer, String> t : treeMap) {
            log.info(t.getValue());
        }

    }

}
