package info.hcooper.pocketevolution.game;

import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Collection;
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
        GameScheduledExecutor gameScheduledExecutor = new GameScheduledExecutor(1);
        gameScheduledExecutor.scheduleAtFixedRate(new ScheduledRefresh(gameFragment), 0L, 33L, TimeUnit.MILLISECONDS);
        gameScheduledExecutor.scheduleAtFixedRate(new ScheduledFood(this), 1L, 1L, TimeUnit.SECONDS);
    }

    public void addDefaultCreatures(int num) {
        screenWidth = gameCanvas.getMeasuredWidth();
        screenHeight = gameCanvas.getMeasuredHeight();
        for (int i = 0; i < num; i++) {
            creatures.add(new Creature(new LocationXY(100f, 100f), BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_circle), 30f, 100));
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
            foods.add(new Food(new LocationXY(new Random().nextInt(screenWidth), new Random().nextInt(screenHeight)), BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_food), 10));
        }
    }

    public void checkEat() {
        Collection<Food> eatenFood = new ArrayList<>();
        for (Food food: foods) {
            float foodX = food.getLocation().getX();
            float foodY = food.getLocation().getY();
            for (Creature creature : creatures) {
                float creatureX = creature.getLocation().getX();
                if (creatureX < foodX && foodX < creatureX + creature.getWidth()) {
                    float creatureY = creature.getLocation().getY();
                    if (creatureY < foodY && foodY < creatureY + creature.getHeight()) {
                        creature.eat(food);
                        eatenFood.add(food);
                        break;
                    }
                }
            }
        }
        foods.removeAll(eatenFood);
    }

    public void checkHunger() {
        Collection<Creature> deadCreatures = new ArrayList<>();
        for (Creature creature : creatures) {
            creature.hunger();
            if (!creature.getAlive()) {
                deadCreatures.add(creature);
            }
        }
        creatures.removeAll(deadCreatures);
    }

    public void checkReproduce() {
        Collection<Creature> newCreatures = new ArrayList<>();
        for (Creature creature : creatures) {
            if (creature.getReproduce()) {
                newCreatures.add(new Creature(creature));
                creature.setReproduce(Boolean.FALSE);
            }
        }
        creatures.addAll(newCreatures);
    }
}
