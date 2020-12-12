package info.hcooper.pocketevolution.ui.game;

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

import info.hcooper.pocketevolution.R;
import info.hcooper.pocketevolution.ui.canvas.CanvasView;

public class GameFragment extends Fragment {

    private GameViewModel gameViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gameViewModel =
                new ViewModelProvider(this).get(GameViewModel.class);
        View root = inflater.inflate(R.layout.fragment_game, container, false);
        //final TextView textView = root.findViewById(R.id.text_slideshow);
        final CanvasView gameCanvas = root.findViewById(R.id.game_canvas);

        return root;
    }
}