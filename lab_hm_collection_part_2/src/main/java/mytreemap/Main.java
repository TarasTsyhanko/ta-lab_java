package mytreemap;

import java.util.Iterator;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        MyTreeMap<Integer, String> treeMap = new MyTreeMap<Integer, String>();
        treeMap.put(2,"Tuesday");
        treeMap.put(6,"Sartaday");
        treeMap.put(1,"Monday");
        treeMap.put(7,"Sunday");
        treeMap.put(3,"Wednesday");
        treeMap.put(1,"Wednesday");
        System.out.println(treeMap.get(1));
        System.out.println(treeMap.get(2));
        System.out.println(treeMap.get(3));
        System.out.println(treeMap.get(6));
        System.out.println(treeMap.get(7));
        System.out.println(treeMap.size());
        TreeMap<Integer,String> map =new TreeMap<Integer, String>();
        Iterator<Integer> t = t.hasNext();
    }
}
