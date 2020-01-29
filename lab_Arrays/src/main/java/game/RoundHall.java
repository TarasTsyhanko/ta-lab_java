package game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoundHall {
    private static final Logger log = LogManager.getLogger(RoundHall.class);
    private Dor[] dor;
    private Hero hero;

    public RoundHall() {
        this.dor = new Dor[]{new Dor(), new Dor(), new Dor(), new Dor(), new Dor(),
                new Dor(), new Dor(), new Dor(), new Dor(), new Dor()};
        this.hero = new Hero();
    }

    public Dor openDor(int i) {
        return dor[i-1];
    }

    public Hero getHero() {
        return hero;
    }
    public boolean isHeroWin(Hero hero, Monster monster){
        if(hero.getPower() - monster.getPower() >=0){
            log.info("Hero \uD83C\uDFA0 WINNN !!!");
            return true;
        }
            log.info("Hero \uD83D\uDC80 DEAD !!!");
            return false;
    }

    public Dor[] getDor() {
        return dor;
    }
}
