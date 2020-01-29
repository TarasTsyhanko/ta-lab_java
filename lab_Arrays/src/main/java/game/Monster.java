package game;

import java.util.Random;

public class Monster {
    private int power ;

    public Monster() {
        this.power = new Random().nextInt(90+1)+5;
    }

    public int getPower() {
        return power;
    }
}
