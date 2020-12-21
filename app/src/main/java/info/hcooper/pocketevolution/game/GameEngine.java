package info.hcooper.pocketevolution.game;

import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import info.hcooper.pocketevolution.R;
import info.hcooper.pocketevolution.models.Creature;
import info.hcooper.pocketevolution.models.CreatureXY;
import info.hcooper.pocketevolution.ui.canvas.CanvasView;

public class GameEngine {

    private CanvasView gameCanvas;
    private ArrayList<Creature> creatures;
    private CreatureXY screenDimens;

    public GameEngine(CanvasView gameCanvas) {
        this.gameCanvas = gameCanvas;
        creatures = new ArrayList<>();
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public void init() {
        GameScheduledExecutor gameScheduledExecutor = new GameScheduledExecutor(1);
        gameScheduledExecutor.scheduleAtFixedRate(new ScheduledRunnable(), 0L, 50L, TimeUnit.MILLISECONDS);
    }

    public void addDefaultCreatures(int num, Context context) {
        screenDimens = new CreatureXY(gameCanvas.getMeasuredWidth(), gameCanvas.getMeasuredHeight());
        System.out.println("width " + screenDimens.getX());
        System.out.println("height " + screenDimens.getY());
        for (int i = 0; i < num; i++) {
            creatures.add(new Creature(new CreatureXY(100f, 100f), BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_circle), 30f));
        }
    }

    public void moveCreatures() {
        for (Creature creature : creatures) {
            creature.move();
        }
    }
}
