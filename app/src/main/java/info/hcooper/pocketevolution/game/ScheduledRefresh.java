package info.hcooper.pocketevolution.game;

public class ScheduledRefresh implements Runnable {

    private final GameFragment gameFragment;

    public ScheduledRefresh(GameFragment gameFragment) {
        this.gameFragment = gameFragment;
    }

    @Override
    public void run() {
        gameFragment.gameEngine.moveCreatures();
        gameFragment.gameEngine.checkEat();
        gameFragment.gameEngine.checkHunger();
        GameFragment.gameCanvas.invalidate();
    }
}
