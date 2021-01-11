package org.academiadecodigo.bitjs.projectcovid.field;

import org.academiadecodigo.bitjs.projectcovid.CollisionDetector;
import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldPosition {
    private int row;
    private int col;

    private Field field;

    private Direction actualDirection;


    public FieldPosition(Field field) {
        this.field = field;
        this.col = (int) (Math.random() * this.field.getCols());
        this.row = (int) (Math.random() * this.field.getRows());
        actualDirection = Direction.values()[(int) Math.random() * Direction.values().length];


    }

    public FieldPosition(int col, int row, Field field, Direction direction) {
        this.col = col;
        this.row = row;
        this.field = field;
        actualDirection = direction;


    }



    public boolean moveRight() {
        if ((col+1)>field.getCols()-1){
            return false;
        }
        if (CollisionDetector.checkMovement(this.col + 1, this.row)) {
            this.col++;
            return true;
        }
        return false;
    }
    public boolean moveLeft() {
        if ((col-1)<0){
            return false;
        }
        if (CollisionDetector.checkMovement(this.col - 1, this.row)) {
            this.col--;
            return true;

        }
        return false;
    }

    public boolean moveUp() {
        if ((row-1)<0){
            return false;
        }
        if (CollisionDetector.checkMovement(this.col , this.row-1)) {
            this.row--;
            return true;
        }
        return false;
    }

    public boolean moveDown() {
        if ((row+1)>field.getRows()-1){
            return false;
        }
        if (CollisionDetector.checkMovement(this.col, this.row + 1)) {
            this.row++;
            return true;
        }
        return false;
    }

    // it is an OVERRIDE BUT it doesn't receive an object it
    public boolean equals(int col, int row) {
        if (this.col == col && this.row == row) {
            return true;
        }
        return false;
    }

    public Field getField() {
        return field;
    }

    public Direction getActualDirection() {
        return actualDirection;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getX() {
        return Field.PADDING + col * Field.CELL_SIZE;
    }


    public void setActualDirection(Direction actualDirection) {
        this.actualDirection = actualDirection;
    }

    public int getY() {
        return Field.PADDING + row * Field.CELL_SIZE;
    }

}
