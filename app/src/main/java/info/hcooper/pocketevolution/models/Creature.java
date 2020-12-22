package info.hcooper.pocketevolution.models;

import android.graphics.Bitmap;
import java.util.Random;
import info.hcooper.pocketevolution.game.GameEngine;

public class Creature extends DrawObject {
    private float speed;
    private LocationXY goingLocation;
    private LocationXY moveFactor;

    public Creature(LocationXY location, Bitmap bitmap, float speed) {
        super(location, bitmap);
        this.speed = speed;
    }

    public void setGoingLocation(LocationXY goingLocation) {
        this.goingLocation = goingLocation;
        float total_x = this.goingLocation.getX() - this.location.getX();
        float total_y = this.goingLocation.getY() - this.location.getY();
        float pos_tot = Math.abs(total_x) + Math.abs(total_y);
        this.moveFactor = new LocationXY(this.speed * total_x / pos_tot, this.speed * total_y / pos_tot);
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

        if (x_rand > GameEngine.screenWidth) {
            x_rand = GameEngine.screenWidth;
        } else if (x_rand < 0) {
            x_rand = 0;
        }

        if (y_rand > GameEngine.screenHeight) {
            y_rand = GameEngine.screenHeight;
        } else if (y_rand < 0) {
            y_rand = 0;
        }
        setGoingLocation(new LocationXY(x_rand, y_rand));
    }
}
