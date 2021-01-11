package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet {

    private Direction direction;
    private Picture bullet;
    private int x, y;


    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        initPicture();
        show();
    }

    public void initPicture() {
        switch (direction) {
            case UP:
                bullet = new Picture(x, y, "resources/Bullet/syringeUp.png");
                break;
            case DOWN:
                bullet = new Picture(x, y, "resources/Bullet/syringeDown.png");
                break;
            case RIGHT:
                bullet = new Picture(x, y, "resources/Bullet/syringeRight.png");
                break;
            case LEFT:
                bullet = new Picture(x, y, "resources/Bullet/syringeLeft.png");
                break;
        }
    }

    public void show() {
        bullet.draw();
    }

    public Picture getBullet() {
        return bullet;
    }

    public void bulletDirection(Direction direction) {
        this.direction = direction;
    }


}
