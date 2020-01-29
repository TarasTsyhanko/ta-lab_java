package comper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

public class MainString {
    private static final Logger log = LogManager.getLogger(Math.class);
    public static void main(String[] args) {
        ArrayList<Europa> list = new ArrayList<Europa>();
        list.add(new Europa("Ukraine","Kyiv"));
        list.add(new Europa("Poland","Warsaw"));
        list.add(new Europa("England","London"));
        list.add(new Europa("Spain","Madrid"));
        Collections.sort(list);
        for (Europa e:list) {
            log.info(e.getCountry());
        }
        Collections.sort(list,new ComparatorEurope());
        for (Europa e:list) {
            log.info(e.getCapital());
        }
    }
}
