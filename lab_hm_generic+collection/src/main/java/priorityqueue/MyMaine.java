package priorityqueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shipwithdroid.Droid;
import shipwithdroid.DroidComparator;

public class MyMaine {
    private static final Logger log = LogManager.getLogger(MyMaine.class);

    public static void main(String[] args) {
        DroidComparator comparator = new DroidComparator();
        MyPriorityQueue<Droid> queue = new MyPriorityQueue(comparator);
        queue.add(new Droid("C", "v"));
        queue.add(new Droid("B", "b"));
        queue.add(new Droid("Y", "k"));
        queue.add(new Droid("A", "a"));
        queue.add(new Droid("H", "k"));
        queue.add(new Droid("U", "t"));
        log.info(queue.isEmpty());
        log.info(queue.size());
        log.info(queue.poll());
        log.info(queue.peek());

        for (Droid d : queue) {
            log.info(d.getName());
        }
    }
}

