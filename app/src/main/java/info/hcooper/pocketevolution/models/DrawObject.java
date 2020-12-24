package info.hcooper.pocketevolution.models;

import android.graphics.Bitmap;

public class DrawObject {
    protected LocationXY location;
    protected Bitmap bitmap;
    private int width;
    private int height;
    private Bitmap sBitmap;

    public DrawObject(LocationXY location, Bitmap bitmap, int width, int height) {
        this.location = location;
        this.bitmap = bitmap;
        this.width = width;
        this.height = height;
        this.sBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
    }

    public LocationXY getLocation() {
        return location;
    }

    public void setLocation(LocationXY location) {
        this.location = location;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.sBitmap = Bitmap.createScaledBitmap(this.bitmap, this.width, this.height, false);
    }

    public Bitmap getsBitmap() {
        return sBitmap;
    }

    public void setsBitmap(Bitmap sBitmap) {
        this.sBitmap = sBitmap;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        this.sBitmap = Bitmap.createScaledBitmap(this.bitmap, this.width, this.height, false);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        this.sBitmap = Bitmap.createScaledBitmap(this.bitmap, this.width, this.height, false);
    }
}
