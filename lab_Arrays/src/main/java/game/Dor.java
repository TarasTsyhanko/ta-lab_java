package game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Dor {
    private MagicArtifact artifact;
    private Monster monster;

    public Dor() {
        int n = new Random().nextInt(2 + 1) + 1;
        if (n == 1) {
            this.artifact = new MagicArtifact();
        } else {
            this.monster = new Monster();
        }
    }

    public MagicArtifact getArtifact() {
        return artifact;
    }

    public void setArtifact(MagicArtifact artifact) {
        this.artifact = artifact;
    }

    public Monster getMonster() {
        return monster;
    }
}
