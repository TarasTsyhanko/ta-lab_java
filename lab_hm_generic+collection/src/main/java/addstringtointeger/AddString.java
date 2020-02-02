package addstringtointeger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class AddString {
    public static void main(String[] args) {
        List<Integer> listInt = new ArrayList<>();
        List listStr = new ArrayList();
        listStr.add("123");
        listStr.add("56");
        listStr.add("string");

        listInt.addAll(listStr);
        System.out.println(listInt);

        for (Integer i:listInt) {
            System.out.println(i);
        }
        TreeMap m = new TreeMap();
        Iterator i =m.pr
    }
}
