package info.hcooper.pocketevolution.models;

import android.graphics.Bitmap;

public class DrawObject {
    protected LocationXY location;
    protected Bitmap bitmap;

    public DrawObject(LocationXY location, Bitmap bitmap) {
        this.location = location;
        this.bitmap = bitmap;
    }

    public LocationXY getLocation() {
        return location;
    }

    public void setLocation(LocationXY location) {
        this.location = location;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
