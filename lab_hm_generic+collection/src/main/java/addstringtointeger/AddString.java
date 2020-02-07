package addstringtointeger;

import java.util.*;

public class AddString {
    public static void main(String[] args) {
        List<Integer> listInt = new ArrayList<>();
        List listStr = new ArrayList();
        listStr.add("56");
        listStr.add("string");

        listInt.addAll(listStr);
        System.out.println(listInt);

       // System.out.println(listInt.get(1));


        char t  = 't';
        System.out.println(30<<3);
        Integer[] array = {1,3,5};
        List<Integer> list = Collections.singletonList(Arrays.asList(array).remove(1));
        System.out.println(list);
    }
}
