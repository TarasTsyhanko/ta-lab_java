package consolemenu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;

public class Menu {
    private static final Logger log = LogManager.getLogger(Menu.class);
    private Months months;
    private Map<Integer, Months> map;

    public Menu() {
        map = new TreeMap<Integer, Months>();
        for (int i = 0; i < months.values().length; i++) {
            map.put(i + 1, months.values()[i]);
        }
    }

    public void openMenu() {
        log.info("please select item ");
        for (int i = 0; i < months.values().length; i++) {
            log.info("press " + (i + 1) + " to select " + map.get(i + 1));
        }
        log.info("press 0  to select EXIT");
    }
    public void makeChoice(){
        int i = User.input();
        if(i == 0){
            System.exit(0);
        }
        log.info(map.get(i).toString() + " - " + map.get(i).getInfo());
    }


}
