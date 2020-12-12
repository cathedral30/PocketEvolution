package info.hcooper.pocketevolution.ui.game;

import android.graphics.Bitmap;

public class Creature {
    private float x;
    private float y;
    private Bitmap bitmap;

    public Creature(float x, float y, Bitmap bitmap) {
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
