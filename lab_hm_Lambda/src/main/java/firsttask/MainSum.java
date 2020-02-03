package firsttask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainSum {
    private static final Logger log = LogManager.getLogger(MainSum.class);
    public static void main(String[] args) {
        Sum sum1 = (a,b,c) -> a+b+c;
        Sum sum2 = (a,b,c) -> (a+b+c)/3;
        log.info((sum1.sumInt(4,8,3)));
        log.info(sum2.sumInt(4,9,5));


    }
}
