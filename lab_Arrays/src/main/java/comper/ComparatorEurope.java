package comper;

import java.util.Comparator;

public class ComparatorEurope implements Comparator<Europa> {
    @Override
    public int compare(Europa o1, Europa o2) {
        return o1.getCapital().compareTo(o2.getCapital());
    }
}
