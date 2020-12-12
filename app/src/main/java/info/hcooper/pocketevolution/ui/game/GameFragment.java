package info.hcooper.pocketevolution.ui.game;

import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

import info.hcooper.pocketevolution.R;
import info.hcooper.pocketevolution.ui.canvas.CanvasView;

public class GameFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_game, container, false);
        final CanvasView gameCanvas = root.findViewById(R.id.game_canvas);

        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.black));
        paint.setAntiAlias(false);

        gameCanvas.setPaint(paint);

        ArrayList<Creature> creatures = new ArrayList<>();

        creatures.add(new Creature(100f, 100f, BitmapFactory.decodeResource(getResources(), R.drawable.ic_circle)));

        gameCanvas.setCreatures(creatures);
        return root;
    }
}