package info.hcooper.pocketevolution.game;

import info.hcooper.pocketevolution.ui.canvas.CanvasView;

public class ScheduledRunnable implements Runnable {

    private final GameFragment gameFragment;

    public ScheduledRunnable(GameFragment gameFragment) {
        this.gameFragment = gameFragment;
    }

    @Override
    public void run() {
        gameFragment.gameEngine.moveCreatures();
        GameFragment.gameCanvas.invalidate();
    }
}
