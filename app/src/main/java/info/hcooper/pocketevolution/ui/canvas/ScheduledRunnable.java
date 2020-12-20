package info.hcooper.pocketevolution.ui.canvas;

import info.hcooper.pocketevolution.ui.game.GameFragment;

public class ScheduledRunnable implements Runnable {

    @Override
    public void run() {
        CanvasView gameCanvas = GameFragment.gameCanvas;
        GameFragment.moveCreatures();
        gameCanvas.invalidate();
    }
}
