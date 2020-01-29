package game;

import java.util.Random;

public class MagicArtifact {
    private int power;

    public MagicArtifact() {
        this.power = new Random().nextInt(70 + 1) +10;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
