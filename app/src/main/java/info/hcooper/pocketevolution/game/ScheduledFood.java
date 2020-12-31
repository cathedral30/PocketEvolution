package info.hcooper.pocketevolution.game;

public class ScheduledFood implements Runnable {

    private final GameEngine gameEngine;

    public ScheduledFood(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void run() {
        gameEngine.addFood(5);
        gameEngine.checkHunger();
        gameEngine.checkReproduce();
    }
}
