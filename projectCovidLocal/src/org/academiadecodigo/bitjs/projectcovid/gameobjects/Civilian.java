package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.bitjs.projectcovid.SoundHandler;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Civilian {

    private boolean infected;
    private FieldPosition fieldPosition;
    private Picture actualPicture;
    private Picture infectedPictureUp;
    private Picture infectedPictureDown;
    private Picture infectedPictureLeft;
    private Picture infectedPictureRight;
    private Picture civilianPictureUp;
    private Picture civilianPictureDown;
    private Picture civilianPictureLeft;
    private Picture civilianPictureRight;


    public Civilian(FieldPosition position) {
        this.fieldPosition = position;
        infected = false;

    }

    public void bootPictures() {
        infectedPictureUp = new Picture(0,0 , "resources/Images/Civilians/civilianInfectedUp.png");
        infectedPictureDown = new Picture(0,0 , "resources/Images/Civilians/civilianInfectedDown.png");
        infectedPictureLeft = new Picture(0,0, "resources/Images/Civilians/civilianInfectedLeft.png");
        infectedPictureRight = new Picture(0,0, "resources/Images/Civilians/civilianInfectedRight.png");
        civilianPictureUp = new Picture(0,0, "resources/Images/Civilians/civilianUp.png");
        civilianPictureDown = new Picture(0,0, "resources/Images/Civilians/civilianDown.png");
        civilianPictureLeft = new Picture(0,0, "resources/Images/Civilians/civilianLeft.png");
        civilianPictureRight = new Picture(0,0, "resources/Images/Civilians/civilianRight.png");
        actualPicture = civilianPictureDown;

    }

    public FieldPosition getFieldPosition() {
        return fieldPosition;
    }

    public boolean isInfected() {
        return infected;
    }

    public void cure() {
        this.infected = false;
        if (this instanceof CivilianGrandma){
            SoundHandler.playSound("granny");
            return;
        }
        if (this instanceof CivilianRapper){
            SoundHandler.playSound("sandrim");
            return;
        }
        if (this instanceof CivilianPolice){
            SoundHandler.playSound("police-cure");
            return;
        }
        if (this instanceof Civilian){
            SoundHandler.playSound("mrT-cure");
            return;
        }


    }

    public void infect() {
        this.infected = true;
    }

    public void showAccordingToDirection() {
        if (actualPicture != null) {

            actualPicture.delete();
        }


        if (isInfected()) {
            switch (fieldPosition.getActualDirection()) {
                case UP:

                    infectedPictureUp.translate(fieldPosition.getX()-infectedPictureUp.getX(),fieldPosition.getY()-infectedPictureUp.getY());
                    actualPicture = infectedPictureUp;
                    break;
                case DOWN:
                    infectedPictureDown.translate(fieldPosition.getX() - infectedPictureDown.getX(), fieldPosition.getY() - infectedPictureDown.getY());
                    actualPicture = infectedPictureDown;
                    break;
                case LEFT:
                    infectedPictureLeft.translate(fieldPosition.getX() - infectedPictureLeft.getX(), fieldPosition.getY() - infectedPictureLeft.getY());
                    actualPicture = infectedPictureLeft;
                    break;
                case RIGHT:
                    infectedPictureRight.translate(fieldPosition.getX() - infectedPictureRight.getX(), fieldPosition.getY() - infectedPictureRight.getY());
                    actualPicture = infectedPictureRight;
                    break;

            }
        } else {
            switch (fieldPosition.getActualDirection()) {
                case UP:
                    civilianPictureUp.translate(fieldPosition.getX() - civilianPictureUp.getX(), fieldPosition.getY() - civilianPictureUp.getY());
                    actualPicture = civilianPictureUp;
                    break;
                case DOWN:
                    civilianPictureDown.translate(fieldPosition.getX() - civilianPictureDown.getX(), fieldPosition.getY() - civilianPictureDown.getY());
                    actualPicture = civilianPictureDown;
                    break;
                case LEFT:
                    civilianPictureLeft.translate(fieldPosition.getX() - civilianPictureLeft.getX(), fieldPosition.getY() - civilianPictureLeft.getY());
                    actualPicture = civilianPictureLeft;
                    break;
                case RIGHT:
                    civilianPictureRight.translate(fieldPosition.getX() - civilianPictureRight.getX(), fieldPosition.getY() - civilianPictureRight.getY());
                    actualPicture = civilianPictureRight;
                    break;

            }
        }
        actualPicture.draw();
    }

    public void deleteCivilianPic() {
        this.actualPicture.delete();
    }

    public void move() {
        int random = (int) (Math.random() * 10);

        switch (fieldPosition.getActualDirection()) {
            case RIGHT:
                if (random > 1) {
                    moveRight();
                } else if (random == 1) {
                    moveUp();
                } else {
                    moveDown();
                }
                break;

            case LEFT:
                if (random > 1) {
                    moveLeft();
                } else if (random == 1) {
                    moveUp();
                } else {
                    moveDown();
                }
                break;
            case DOWN:
                if (random > 1) {
                    moveDown();
                } else if (random == 1) {
                    moveLeft();
                } else {
                    moveRight();
                }
                break;
            case UP:
                if (random > 1) {
                    moveUp();
                } else if (random == 1) {
                    moveLeft();
                } else {
                    moveRight();
                }
                break;
        }
    }


    public void moveRight() {


        if (fieldPosition.moveRight()) {
            fieldPosition.setActualDirection(Direction.RIGHT);
        } else {
            fieldPosition.setActualDirection(Direction.LEFT);
            fieldPosition.moveLeft();
        }

        showAccordingToDirection();

    }

    public void moveLeft() {


        if (fieldPosition.moveLeft()) {
            fieldPosition.setActualDirection(Direction.LEFT);
        } else {
            fieldPosition.setActualDirection(Direction.RIGHT);
            fieldPosition.moveRight();
        }
        showAccordingToDirection();

    }

    public void moveUp() {


        if (fieldPosition.moveUp()) {
            fieldPosition.setActualDirection(Direction.UP);
        } else {
            fieldPosition.setActualDirection(Direction.DOWN);
            fieldPosition.moveDown();
        }

        showAccordingToDirection();

    }

    public void setActualPicture(Picture actualPicture) {
        this.actualPicture = actualPicture;
    }

    public void setInfectedPictureUp(Picture infectedPictureUp) {
        this.infectedPictureUp = infectedPictureUp;
    }

    public void setInfectedPictureDown(Picture infectedPictureDown) {
        this.infectedPictureDown = infectedPictureDown;
    }

    public void setInfectedPictureLeft(Picture infectedPictureLeft) {
        this.infectedPictureLeft = infectedPictureLeft;
    }

    public void setInfectedPictureRight(Picture infectedPictureRight) {
        this.infectedPictureRight = infectedPictureRight;
    }

    public void setCivilianPictureUp(Picture civilianPictureUp) {
        this.civilianPictureUp = civilianPictureUp;
    }

    public void setCivilianPictureLeft(Picture civilianPictureLeft) {
        this.civilianPictureLeft = civilianPictureLeft;
    }

    public void setCivilianPictureRight(Picture civilianPictureRight) {
        this.civilianPictureRight = civilianPictureRight;
    }

    public Picture getCivilianPictureDown() {
        return civilianPictureDown;
    }

    public void setCivilianPictureDown(Picture civilianPictureDown) {
        this.civilianPictureDown = civilianPictureDown;
    }

    public void moveDown() {


        if (fieldPosition.moveDown()) {
            fieldPosition.setActualDirection(Direction.DOWN);
        } else {
            fieldPosition.setActualDirection(Direction.UP);
            fieldPosition.moveUp();
        }
        showAccordingToDirection();

    }

    public Picture getInfectedPictureUp() {
        return infectedPictureUp;
    }

    public Picture getCivilianPictureUp() {
        return civilianPictureUp;
    }

    @Override
    public String toString(){

        return this.getClass().getSimpleName();
    }
}
