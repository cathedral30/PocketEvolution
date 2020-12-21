package info.hcooper.pocketevolution.game;

import info.hcooper.pocketevolution.ui.canvas.CanvasView;

public class ScheduledRunnable implements Runnable {

    @Override
    public void run() {
        CanvasView gameCanvas = GameFragment.gameCanvas;
        GameFragment.gameEngine.moveCreatures();
        gameCanvas.invalidate();
    }
}
