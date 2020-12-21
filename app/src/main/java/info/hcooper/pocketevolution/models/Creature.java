package info.hcooper.pocketevolution.models;

import android.graphics.Bitmap;

import java.util.Random;

public class Creature {
    private CreatureXY location;
    private Bitmap bitmap;
    private float speed;
    private CreatureXY goingLocation;
    private CreatureXY moveFactor;

    public Creature(CreatureXY location, Bitmap bitmap, float speed) {
        this.location = location;
        this.bitmap = bitmap;
        this.speed = speed;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public CreatureXY getLocation() {
        return location;
    }

    public void setGoingLocation(CreatureXY goingLocation) {
        this.goingLocation = goingLocation;
        float total_x = this.goingLocation.getX() - this.location.getX();
        float total_y = this.goingLocation.getY() - this.location.getY();
        float pos_tot = Math.abs(total_x) + Math.abs(total_y);
        this.moveFactor = new CreatureXY(this.speed * total_x / pos_tot, this.speed * total_y / pos_tot);
    }

    public void move() {
        if (this.goingLocation != null) {
            if (Math.abs(this.goingLocation.getX() - this.location.getX()) < this.speed && Math.abs(this.goingLocation.getY() - this.location.getY()) < this.speed) {
                this.location = this.goingLocation;
                this.goingLocation = null;
            } else {
                this.location.setX(this.location.getX() + this.moveFactor.getX());
                this.location.setY(this.location.getY() + this.moveFactor.getY());
            }
        } else {
            chooseRandDestination();
        }
    }

    public void chooseRandDestination() {
        float x_rand = 300 - new Random().nextInt(600) + this.location.getX();
        float y_rand = 400 - new Random().nextInt(800) + this.location.getY();

        if (x_rand > 1080) {
            x_rand = 1080;
        } else if (x_rand < 0) {
            x_rand = 0;
        }

        if (y_rand > 1868) {
            y_rand = 1868;
        } else if (y_rand < 0) {
            y_rand = 0;
        }
        setGoingLocation(new CreatureXY(x_rand, y_rand));
    }
}
