package info.hcooper.pocketevolution.models;

import android.graphics.Bitmap;

public class Food extends DrawObject {

    private int sustenance;

    public Food(LocationXY location, Bitmap bitmap, int sustenance) {
        super(location, bitmap, 20, 20);
        this.sustenance = sustenance;
    }

    public int getSustenance() {
        return sustenance;
    }
}
