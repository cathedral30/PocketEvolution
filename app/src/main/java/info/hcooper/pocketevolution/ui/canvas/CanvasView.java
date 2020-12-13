package info.hcooper.pocketevolution.ui.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import info.hcooper.pocketevolution.ui.game.Creature;

public class CanvasView extends View {
    private Paint paint;
    private ArrayList<Creature> creatures;

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
        for (Creature c : creatures) {
            canvas.drawBitmap(c.getBitmap(), c.getX(), c.getY(), paint);
        }
    }

    public void refresh(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        this.draw(canvas);
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public void setCreatures(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }
}
