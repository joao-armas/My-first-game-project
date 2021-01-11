package org.academiadecodigo.bitjs.projectcovid.field;

import org.academiadecodigo.bitjs.projectcovid.CollisionDetector;
import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Bullet;

public class BulletFieldPosition extends FieldPosition {

    private Bullet bullet;


    public BulletFieldPosition(Field field, int col, int row,
                               Direction direction) {

        super(col, row, field, direction);
        if(col>=field.getCols()){
            System.out.println();
            this.bullet=new Bullet(Field.colsToX(super.getCol()-1), Field.rowsToY(super.getRow()), super.getActualDirection());
            return;
        }
        if(row>=field.getRows()){
            this.bullet=new Bullet(Field.colsToX(super.getCol()), Field.rowsToY(super.getRow()-1), super.getActualDirection());
            return;

        }
        this.bullet = new Bullet(Field.colsToX(super.getCol()), Field.rowsToY(super.getRow()), super.getActualDirection());
    }

    public boolean moveBullet(int speed) {
        CollisionDetector.checkBulletHit(this);


        switch (super.getActualDirection()) {
            case LEFT:
                return moveBulletLeft(speed);
            case RIGHT:
                return moveBulletRight(speed);
            case DOWN:
                return moveBulletDown(speed);
            case UP:
                return moveBulletUp(speed);
        }
        return false;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public boolean moveBulletDown(int speed) {

        for (int i = 0; i <= speed; i++) {
            int firstY = super.getY();
            if (super.getRow() + 2 > super.getField().getRows()) {
                bullet.getBullet().delete();
                return false;
            }
            super.setRow(super.getRow() + 1);
            if (CollisionDetector.checkBulletHit(this)) {
                bullet.getBullet().delete();
                return false;
            }
            int difY = super.getY() - firstY;
            this.bullet.getBullet().translate(0, difY);
            this.bullet.show();
            addDelay(15);


        }
        return true;
    }

    public boolean moveBulletUp(int speed) {

        for (int i = 0; i <= speed; i++) {
            int firstY = super.getY();
            if (super.getRow() - 1 < 0) {
                bullet.getBullet().delete();
                return false;
            }
            super.setRow(super.getRow() - 1);
            if (CollisionDetector.checkBulletHit(this)) {
                bullet.getBullet().delete();
                return false;
            }
            int difY = super.getY() - firstY;
            this.bullet.getBullet().translate(0, difY);
            this.bullet.show();
            addDelay(15);

        }
        return true;
    }

    public boolean moveBulletRight(int speed) {

        for (int i = 0; i <= speed; i++) {
            int firstX = super.getX();
            if (super.getCol() + 2 > super.getField().getCols()) {
                bullet.getBullet().delete();
                return false;
            }
            super.setCol(super.getCol() + 1);
            if (CollisionDetector.checkBulletHit(this)) {
                bullet.getBullet().delete();
                return false;
            }
            CollisionDetector.checkBulletHit(this);
            int difX = super.getX() - firstX;
            this.bullet.getBullet().translate(difX, 0);
            this.bullet.show();
            addDelay(15);
        }
        return true;
    }

    public boolean moveBulletLeft(int speed) {

        for (int i = 0; i <= speed; i++) {
            int firstX = super.getX();
            if (super.getCol() - 1 < 0) {
                bullet.getBullet().delete();
                return false;
            }
            super.setCol(super.getCol() - 1);
            if (CollisionDetector.checkBulletHit(this)) {
                bullet.getBullet().delete();
                return false;
            }
            CollisionDetector.checkBulletHit(this);
            int difX = super.getX() - firstX;
            this.bullet.getBullet().translate(difX, 0);
            this.bullet.show();
            addDelay(15);
        }
        return true;
    }

    public void addDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
