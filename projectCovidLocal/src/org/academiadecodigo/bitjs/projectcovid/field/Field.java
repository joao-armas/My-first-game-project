package org.academiadecodigo.bitjs.projectcovid.field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    public static final int CELL_SIZE = 51;
    public static final int PADDING = 10;
    private static int width;
    private static int height;
    private int cols;
    private int rows;
    private Picture field;


    public Field(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.width = cols * CELL_SIZE;
        this.height = rows * CELL_SIZE;


    }

    public static int colsToX(int cols) {
        return PADDING + (cols * CELL_SIZE);
    }

    public static int rowsToY(int rows) {
        return PADDING + (rows * CELL_SIZE);
    }

    public void init() {
        this.field = new Picture(PADDING, PADDING, "resources/Menus/menu_start.png");
        field.draw();
    }

    public void show() {
        field.draw();
    }

    public void setPicture(Picture picture) {
        this.field = (picture);
    }
    public void deletePicture(){
        this.field.delete();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }

    public int getWidth() {
        return this.field.getWidth();
    }

    public int getHeight() {
        return this.field.getHeight();
    }
}
