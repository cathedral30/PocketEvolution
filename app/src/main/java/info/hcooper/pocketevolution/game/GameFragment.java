package info.hcooper.pocketevolution.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import info.hcooper.pocketevolution.R;
import info.hcooper.pocketevolution.models.Creature;
import info.hcooper.pocketevolution.models.Food;
import info.hcooper.pocketevolution.ui.canvas.CanvasView;

public class GameFragment extends Fragment {

    public static CanvasView gameCanvas;
    public GameEngine gameEngine;
    public static ArrayList<Creature> creatures;
    public static ArrayList<Food> foods;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_game, container, false);
        gameCanvas = root.findViewById(R.id.game_canvas);
        gameEngine = new GameEngine(gameCanvas, getContext());
        gameEngine.init(this);

        FloatingActionButton addbutton = root.findViewById(R.id.addCreatureButton);
        addbutton.setOnClickListener(v -> gameEngine.addDefaultCreatures(1));

        return root;
    }
}
