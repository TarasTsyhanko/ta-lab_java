package fourstask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(new Text().getList());
        log.info(list + " our list of String");

        List<String> list1 = list.stream().flatMap(e -> Stream.of(e.split(" "))).collect(Collectors.toList());
        List<String> uniqueList = list1.stream().distinct().collect(Collectors.toList());
        log.info(uniqueList);
        log.info(uniqueList.stream().distinct().count());

        List<String> sortedList = list1.stream().sorted().collect(Collectors.toList());
        log.info(sortedList);

        uniqueList.stream().forEach((a) -> System.out.print(a + "-" + list1.indexOf(a) + " "));
        List<String> listLetter = list1.stream().flatMap(e -> Stream.of(e.split(""))).collect(Collectors.toList());

        log.info("");
        listLetter.stream().filter(a -> a.equals(a.toLowerCase()))
                .forEach(a -> System.out.print(a + "-" + listLetter.indexOf(a) + " "));
    }
}
