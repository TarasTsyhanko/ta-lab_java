package thirdtask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public Integer[] getArray() {
        Integer[] array = new Integer[new Random().nextInt(15 + 5) + 5];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(12 + 1);
        }
        return array;
    }

    public static void main(String[] args) {
        Main m = new Main();

        List<Integer> list = Arrays.asList(m.getArray());

        log.info(list);
        log.info(list.stream().reduce(Integer::sum));
        log.info(list.stream().sorted().max(Integer::compareTo));
        log.info(list.stream().sorted().min(Integer::compareTo));

        log.info(list.stream().mapToInt(Integer::intValue).summaryStatistics());

        double average = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        double[] averageBig = list.stream().mapToDouble(Integer::doubleValue).filter(i -> i >average).toArray();

        log.info(Arrays.toString(averageBig));
        log.info(list.stream().sorted(Integer::compareTo).collect(Collectors.toList()));

    }
}
