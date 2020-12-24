package info.hcooper.pocketevolution.ui.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import java.util.ConcurrentModificationException;

import info.hcooper.pocketevolution.models.Creature;
import info.hcooper.pocketevolution.game.GameFragment;
import info.hcooper.pocketevolution.models.Food;

public class CanvasView extends View {
    private Paint paint;

    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDraw(Canvas canvas) {
        for (Creature c : GameFragment.creatures) {
            canvas.drawBitmap(c.getsBitmap(), c.getLocation().getX(), c.getLocation().getY(), paint);
        }
        try {
            for (Food f : GameFragment.foods) {
                canvas.drawBitmap(f.getsBitmap(), f.getLocation().getX(), f.getLocation().getY(), paint);
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Concurrent error caught");
        }
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
