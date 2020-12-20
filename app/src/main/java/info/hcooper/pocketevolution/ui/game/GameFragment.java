package info.hcooper.pocketevolution.ui.game;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import info.hcooper.pocketevolution.R;
import info.hcooper.pocketevolution.ui.canvas.CanvasView;
import info.hcooper.pocketevolution.ui.canvas.GameScheduledExecutor;
import info.hcooper.pocketevolution.ui.canvas.ScheduledRunnable;

public class GameFragment extends Fragment {

    public static CanvasView gameCanvas;
    public static ArrayList<Creature> creatures;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_game, container, false);
        gameCanvas = root.findViewById(R.id.game_canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(false);

        gameCanvas.setPaint(paint);

        GameScheduledExecutor gameScheduledExecutor = new GameScheduledExecutor(1);
        gameScheduledExecutor.scheduleAtFixedRate(new ScheduledRunnable(), 0L, 50L, TimeUnit.MILLISECONDS);

        creatures = new ArrayList<>();
        creatures.add(new Creature(new CreatureXY(100f, 100f), BitmapFactory.decodeResource(getResources(), R.drawable.ic_circle), 30f));
        creatures.add(new Creature(new CreatureXY(100f, 100f), BitmapFactory.decodeResource(getResources(), R.drawable.ic_circle), 30f));
        creatures.add(new Creature(new CreatureXY(100f, 100f), BitmapFactory.decodeResource(getResources(), R.drawable.ic_circle), 40f));
        creatures.add(new Creature(new CreatureXY(100f, 100f), BitmapFactory.decodeResource(getResources(), R.drawable.ic_circle), 40f));
        creatures.add(new Creature(new CreatureXY(100f, 100f), BitmapFactory.decodeResource(getResources(), R.drawable.ic_circle), 20f));
        return root;
    }

    public static void moveCreatures() {
        for (Creature creature : creatures) {
            creature.move();
        }
    }
}