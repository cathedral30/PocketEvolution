package info.hcooper.pocketevolution.ui.game;

import android.graphics.Bitmap;

public class Creature {
    private float x;
    private float y;
    private Bitmap bitmap;
    private int speed;

    public Creature(float x, float y, Bitmap bitmap, int speed) {
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
        this.speed = speed;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
