package priorityqueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shipwithdroid.Droid;
import shipwithdroid.DroidComparator;

import java.util.Iterator;

public class MyMaine {
    private static final Logger log = LogManager.getLogger(MyMaine.class);

    public static void main(String[] args) {
        DroidComparator comparator = new DroidComparator();
        MyPriorityQueue<Droid> queue = new MyPriorityQueue(comparator);
        queue.add(new Droid("C", "a"));
        queue.add(new Droid("B", "b"));
        queue.add(new Droid("A", "k"));
        queue.add(new Droid("A", "v"));
        queue.add(new Droid("H", "k"));
        queue.add(new Droid("F", "t"));
        log.info(queue.isEmpty());
        log.info(queue.size());
        log.info(queue.peek());
        log.info(queue.poll());
        log.info(queue.poll());
        System.out.println();
        Iterator<Droid> iter = queue.iterator();

        while(iter.hasNext()) {
            iter.remove();
        }

        log.info(queue.size());
        log.info(queue.isEmpty());
    }
}

