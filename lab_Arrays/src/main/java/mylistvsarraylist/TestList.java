package mylistvsarraylist;

import java.util.List;

public class TestList {
    public long testList(ArrayString list){
        long start1 = System.nanoTime();
        for (int i = 0; i <500000 ; i++) {
            list.add("one");
            list.addIndex(i,"two");
        }
        long end1 = System.nanoTime() - start1;
        return end1;
    }
    public long testArrayList(List<String> list){
        long start1 = System.nanoTime();
        for (int i = 0; i <500000 ; i++) {
            list.add("one");
            list.add(i,"two");
        }
        long end1 = System.nanoTime() - start1;
        return end1;
    }
}
