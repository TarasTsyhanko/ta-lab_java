package arraystasks;

import java.util.Random;

public class CreateArray {

    public int[] getNewArray(){
        int[] array = new int[new Random().nextInt(15+10)+5];
        for (int i = 0; i <array.length ; i++) {
            array[i]= new Random().nextInt(10+1);
        }
        return array;
    }
}
