package shipwithdroid;

import java.util.Comparator;

public class DroidComparator implements Comparator<Droid> {
    public DroidComparator() {
    }

    public int compare(Droid o1, Droid o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
