package consolemenu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;

public class Menu {
    private static final Logger log = LogManager.getLogger(Menu.class);
    private Map<Integer, Months> map;

    public Menu() {
        map = new TreeMap<Integer, Months>();
        for (int i = 0; i < Months.values().length; i++) {
            map.put(i + 1, Months.values()[i]);
        }
    }

    public Map<Integer, Months> getMap() {
        return map;
    }
    public void showDescriptionsFirst(){
        log.info("please select item ");
        for (int i = 0; i < Months.values().length; i++) {
            log.info("press " + (i + 1) + " to select " + map.get(i + 1));
        }
        log.info("press 0  to select EXIT");
    }
    public void showDescriptionsSecond(){
        log.info("please select item ");
        log.info("press BACK to go in previous menu or 0 to EXIT");
    }
    public void showInfo(int i){
        log.info(map.get(i).toString() + " - " + map.get(i).getInfo());
    }
    public void shutDown(){
        System.exit(0);
    }
}
