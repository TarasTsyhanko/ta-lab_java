package game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Play {
    private static final Logger log = LogManager.getLogger(RoundHall.class);
    private RoundHall hall;

    public Play() {
        this.hall = new RoundHall();
        playGame();
    }

    public void playGame() {
        while (true) {
            helpInformation();
            Dor dor = hall.openDor(hall.getHero().selectDor());
            if (dor.getMonster() != null) {
                log.info("Hero meet monster \uD83D\uDC32  with power " + dor.getMonster().getPower() +
                        " Hero`s power " + hall.getHero().getPower());
                hall.isHeroWin(hall.getHero(), dor.getMonster());
                return;
            } else if (dor.getArtifact() != null) {
                log.info("Hero finds artifact with power " + dor.getArtifact().getPower());
                hall.getHero().setPower(hall.getHero().getPower() + dor.getArtifact().getPower());
                dor.setArtifact(null);
            } else {
                log.info("Room is empty");
            }

        }
    }

    public void helpInformation() {
        int i = 0;
        List<Integer> list = new ArrayList<>();
        for (Dor doors : hall.getDor()) {
            if (doors.getMonster() != null && doors.getMonster().getPower() > hall.getHero().getPower()) {
                list.add(i + 1);
            }
            i++;
        }
        log.info("Death awaits the hero in doors number " + list);
    }
}
