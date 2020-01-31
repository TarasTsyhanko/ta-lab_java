package mytreemap;

import consolemenu.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.TreeMap;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        MyTreeMap<Integer, String> treeMap = new MyTreeMap<Integer, String>();
        treeMap.put(2,"Tuesday");
        treeMap.put(6,"Sartaday");
        treeMap.put(1,"Monday");
        treeMap.put(7,"Sunday");
        treeMap.put(3,"Wednesday");
        treeMap.put(1,"Wednesday");
        log.info(treeMap.get(1));
        log.info(treeMap.get(2));
        log.info(treeMap.get(3));
        log.info(treeMap.get(6));
        log.info(treeMap.get(7));
        log.info(treeMap.size());

    }
}
