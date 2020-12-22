package info.hcooper.pocketevolution.game;

import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import info.hcooper.pocketevolution.R;
import info.hcooper.pocketevolution.models.Creature;
import info.hcooper.pocketevolution.models.Food;
import info.hcooper.pocketevolution.models.LocationXY;
import info.hcooper.pocketevolution.ui.canvas.CanvasView;

import static info.hcooper.pocketevolution.game.GameFragment.creatures;
import static info.hcooper.pocketevolution.game.GameFragment.foods;

public class GameEngine {

    private final CanvasView gameCanvas;
    public static Integer screenWidth;
    public static Integer screenHeight;
    private final Context context;

    public GameEngine(CanvasView gameCanvas, Context context) {
        this.gameCanvas = gameCanvas;
        this.context = context;
    }

    public void init(GameFragment gameFragment) {
        creatures = new ArrayList<>();
        foods = new ArrayList<>();
        GameScheduledExecutor gameScheduledExecutor = new GameScheduledExecutor(2);
        gameScheduledExecutor.scheduleAtFixedRate(new ScheduledRefresh(gameFragment), 0L, 50L, TimeUnit.MILLISECONDS);
        gameScheduledExecutor.scheduleAtFixedRate(new ScheduledFood(this), 1L, 1L, TimeUnit.SECONDS);
    }

    public void addDefaultCreatures(int num) {
        screenWidth = gameCanvas.getMeasuredWidth();
        screenHeight = gameCanvas.getMeasuredHeight();
        for (int i = 0; i < num; i++) {
            creatures.add(new Creature(new LocationXY(100f, 100f), BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_circle), 30f));
        }
    }

    public void moveCreatures() {
        for (Creature creature : creatures) {
            creature.move();
        }
    }

    public void addFood(int num) {
        screenWidth = gameCanvas.getMeasuredWidth();
        screenHeight = gameCanvas.getMeasuredHeight();
        for (int i = 0; i < num; i++) {
            foods.add(new Food(new LocationXY(new Random().nextInt(screenWidth), new Random().nextInt(screenHeight)), BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_food)));
        }
    }
}
