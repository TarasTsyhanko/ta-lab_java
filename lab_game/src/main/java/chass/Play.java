package chass;

import chass.Service.RulesService;
import chass.Service.VisualService;

public class Play {
    public static void main(String[] args) {
        RulesService rule = new RulesService();
        VisualService visualService = new VisualService();
        visualService.createGameField();
        while (true){
            visualService.move.chooseFigure();
            visualService.createGameField();
            if (rule.isGameOver(visualService.move)){
                break;
            }

        }
    }
}
