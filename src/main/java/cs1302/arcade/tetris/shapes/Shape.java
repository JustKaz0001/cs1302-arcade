package cs1302.arcade.tetris.shapes;

import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.Node;

/** 
 * Represents a class for all {@code Shape} shapes.
 */
public abstract class Shape {
    public GridPane gridP;
    public int angle;
    public Rectangle rect1;
    public Rectangle rect2;
    public Rectangle rect3;
    public Rectangle rect4;
    public int pivotX;
    public int pivotY; //pivot point for X and Y
    public Rectangle[] rectangles = new Rectangle[4];
    public Color color;
    
    /**
     * rewrites values for {@code Shape} objects.
     * @param y the y value to set {@code pivotY} to
     * @param g the {@code GridPane} that stores the {@code Rectangle} objects
     * @param c the desired {@code Color} for the shape
     */
    public Shape(int y , GridPane g , Color c) {
        angle = 0; //All shapes start at 0 aka OG position
        pivotY = y;
        color = c;
        gridP = g;
    } //Shape method

    /**
     * Calls and arranges shapes accordingly based on call.
     */
    public void rotate() {
        //all angles
        switch (angle) {
        case 270:
            rotateTo0();
            break;
        case 180:
            rotateTo270();
            break;
        case 90:
            rotateTo180();
            break;
        case 0:
            rotateTo90();
            break;
        } //switch
    } //rotate

    /** 
     * Adds a {@code Rectangle} at certain column or row.
     * @param column the specific column
     * @param row the specific row
     * @return the {@code Rectangle}
     */
    public Rectangle addRectangle(int column, int row) {
        //adds color to rectangle
        Rectangle rect = new Rectangle(30, 30);
        rect.setFill(color);
        gridP.add(rect, column, row);
        return rect;
    } //addRectangle

    /**
     * Removes certain {@code Rectangle} from {@code grid}.
     * @param rect the {@code Rectangle} that is to be removed
     */
    public void removeRectangle(Rectangle rect) {
        //takes out a rectangle
        gridP.getChildren().remove(rect);
    } //removeRectangle


    /**
     * Moves the shape left by 1 column.
     */
    public void moveLeft() {
        //sets moveable and rows and cols
        boolean moveable = true;
        int column, row;
        for (Rectangle rect : rectangles) {
            if (rect != null) {
                // columns and rows
                column = GridPane.getColumnIndex(rect);
                row = GridPane.getRowIndex(rect);
                if (column == 0) { //if rect all the way left
                    moveable = false; //cant move
                } else {
                    // if isnt rect 
                    Rectangle rectNext = getFromGrid(column - 1, row);
                    if (rectNext != null && isntRect(rectNext) == true) {
                        moveable = false;
                    } //if
                }
            } //if
        } //for
        if (moveable) {
            for (Rectangle rect : rectangles) {
                GridPane.setColumnIndex(rect, GridPane.getColumnIndex(rect) - 1);
            } //for
            pivotX--;
        } //if
    } //moveLeft

    /**
     * Moves shapes down by 1.
     * @return true if shape is able to move down at all
     */
    public boolean moveDown() {
        boolean moveable = true; //make this a private variable?
        int column, row; //make these private too??
        for (Rectangle rect : rectangles) {
            if (rect != null) { //cant move almost at last line
                column = GridPane.getColumnIndex(rect);
                row = GridPane.getRowIndex(rect);
                if (row == 19) { 
                    moveable = false;
                } else { //cant go down further
                    Rectangle rectNext = getFromGrid(column, row + 1);
                    if (rectNext != null && isntRect(rectNext) == true) {
                        moveable = false;
                    }
                }
            }
        }
        if (moveable) { //can move so returns moves as true
            for (Rectangle rect : rectangles) {
                GridPane.setRowIndex(rect, GridPane.getRowIndex(rect) + 1);
            }
            pivotY++;
        }
        return moveable;
    } //moveDown

    /**
     * Moves shape as low as it can go.
     */
    public void moveToBottom() {
        //keeps moving till moveDown is false
        do {
            moveDown();
        } while (moveDown() == true);
        // while (moveDown() == true);
    }

    /**
     * Moves  shape to the right by 1 if possible.
     */
    public void moveRight() {
        boolean moveable = true;
        int column, row; //repetition
        for (Rectangle rect : rectangles) {
            if (rect != null) {
                column = GridPane.getColumnIndex(rect);
                row = GridPane.getRowIndex(rect);
                if (column == 9) { //If rect all the way to right and cant go further
                    moveable = false;
                } else {
                    //checks to see if can moce
                    Rectangle rectNext = getFromGrid(column + 1, row);
                    if (rectNext != null && isntRect(rectNext) == true) {
                        moveable = false;
                    } //if
                } //if
            } //if
        } //for
        if (moveable == true) {
            //moves the shape 
            for (Rectangle rect : rectangles) {
                GridPane.setColumnIndex(rect, GridPane.getColumnIndex(rect) + 1);
            } //for
            pivotX++;
        } //if
    } //moveRight

    /**
     * Reassigns all the rectangles to the appropriate places in rectangles array.
     */
    public void reassignRectangles() {
        //assigns positions in rectangkles array
        rectangles[0] = rect1;
        rectangles[1] = rect2;
        rectangles[2] = rect3;
        rectangles[3] = rect4;
    } //reassignRectangle


    /**
     * Returns a {@code Rectangle} object at a specific part of the grid.
     * @throws IndexOutOfBoundsException if column or row are out of indeces
     * @param column column of {@code grid}
     * @param row row of {@code grid}
     * @return the {@code Rectangle} object at certain indeces null if not there
     */
    public Rectangle getFromGrid(int column, int row) {
        //checks if in bounds
        if (column < 0 || column > 9 || row < 0 || row > 19) {
            throw new IndexOutOfBoundsException();
        }
        //if rect not null then returns it 
        for (Node node : gridP.getChildren()) {
            //gridpane not gridp
            if (node != null && GridPane.getColumnIndex(node) != null 
                && GridPane.getRowIndex(node) != null) {
                if (GridPane.getColumnIndex(node) == column && GridPane.getRowIndex(node) == row) {
                    return (Rectangle)node;
                } //if
            } //if
        } //from
        return null;
    } //getFromGrid
    
    /**
     * Checks {@code Rectangle} to see if its one of tge rectangles.
     * @param rect the inputted {@code Rectangle}
     * @return true if certain {@code Rectangle} is not one of the 4 rectangles.
     */
    public boolean isntRect(Rectangle rect) {
        boolean isRect = false; //assigns false to boolean
        if (rect != rect1 && rect != rect2 && rect != rect3 && rect != rect4) {
            isRect = true;
        } //if
        return isRect;
    } //isntRect

    //Doesnt need it. assigned individually
    /**
     * Rotates from 180 to 270 degrees.
     */
    public abstract void rotateTo270();

    /**
     * Rotates from 90 to 180 degrees.
     */
    public abstract void rotateTo180();

    /**
     * Rotates from 0 to 90 degrees.
     */
    public abstract void rotateTo90();

    /**
     * Rotates from 270 to 0 degrees.
     */
    public abstract void rotateTo0();
} //Shape class
