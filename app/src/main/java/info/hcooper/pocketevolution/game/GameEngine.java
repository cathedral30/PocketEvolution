package info.hcooper.pocketevolution.game;

import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import info.hcooper.pocketevolution.R;
import info.hcooper.pocketevolution.models.Creature;
import info.hcooper.pocketevolution.models.CreatureXY;
import info.hcooper.pocketevolution.ui.canvas.CanvasView;

import static info.hcooper.pocketevolution.game.GameFragment.creatures;

public class GameEngine {

    private final CanvasView gameCanvas;
    public static CreatureXY screenDimens;
    private final Context context;

    public GameEngine(CanvasView gameCanvas, Context context) {
        this.gameCanvas = gameCanvas;
        this.context = context;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public void init(GameFragment gameFragment) {
        creatures = new ArrayList<>();
        GameScheduledExecutor gameScheduledExecutor = new GameScheduledExecutor(1);
        gameScheduledExecutor.scheduleAtFixedRate(new ScheduledRunnable(gameFragment), 0L, 50L, TimeUnit.MILLISECONDS);
    }

    public void addDefaultCreatures(int num) {
        screenDimens = new CreatureXY(gameCanvas.getMeasuredWidth(), gameCanvas.getMeasuredHeight());
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
