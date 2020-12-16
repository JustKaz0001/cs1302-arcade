package cs1302.arcade.tetris.shapes;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Makes a Z shape in Tetris.
 */
public class ZShape extends Shape {

    /**
     * Sets all the aspects for a Z shape.
     * @param gridP a reference to the {@code GridPane} thatcontains the {@code Rectangle} objects
     */
    public ZShape(GridPane gridP) {
        super(1, gridP, Color.RED);
        pivotX = (int)(Math.random() * 8) + 1; //random int from 1 to

        //pivot in a way to form a Z
        rect1 = addRectangle(pivotX, pivotY);
        rect2 = addRectangle(pivotX, pivotY - 1);
        rect3 = addRectangle(pivotX - 1, pivotY - 1);
        rect4 = addRectangle(pivotX + 1, pivotY);
        
        reassignRectangles();
    } //ZShape method

    /** {@inheritDoc} */
    public void rotateTo270() {
        //Rotates shapes accordingly
        try {
            Rectangle nRect2 = getFromGrid(pivotX, pivotY - 1);
            Rectangle nRect3 = getFromGrid(pivotX - 1, pivotY + 1);
            if (nRect2 == null && nRect3 == null) {
                removeRectangle(rect2);
                removeRectangle(rect3);
                rect2 = addRectangle(pivotX, pivotY - 1);
                rect3 = addRectangle(pivotX - 1, pivotY + 1);
                reassignRectangles();
                angle = 270;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds");
        }
    } //rotateto270

    /** {@inheritDoc} */
    public void rotateTo180() {
        //Rotates shapes accordingly
        try {
            Rectangle nRect4 = getFromGrid(pivotX - 1, pivotY);
            Rectangle nRect3 = getFromGrid(pivotX + 1, pivotY + 1);
            if (nRect4 == null && nRect3 == null) {
                removeRectangle(rect4);
                removeRectangle(rect3);
                rect4 = addRectangle(pivotX - 1, pivotY);
                rect3 = addRectangle(pivotX + 1, pivotY + 1);
                reassignRectangles();
                angle = 180;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of Bounds");
        }
    } //rotateTo180

    /** {@inheritDoc} */
    public void rotateTo90() {
        //Rotates shapes accordingly
        try {
            Rectangle nRect2 = getFromGrid(pivotX, pivotY + 1);
            Rectangle nRect3 = getFromGrid(pivotX + 1, pivotY - 1);
            if (nRect2 == null && nRect3 == null) {
                removeRectangle(rect2);
                removeRectangle(rect3);
                rect2 = addRectangle(pivotX, pivotY + 1);
                rect3 = addRectangle(pivotX + 1, pivotY - 1);
                reassignRectangles();
                angle = 90;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of Bounds");
        }
    } //rotateTo90

    /** {@inheritDoc} */
    public void rotateTo0() {
        //Rotates shapes accordingly
        try {
            Rectangle nRect4 = getFromGrid(pivotX + 1, pivotY);
            Rectangle nRect3 = getFromGrid(pivotX - 1, pivotY - 1);
            if (nRect4 == null && nRect3 == null) {
                removeRectangle(rect4);
                removeRectangle(rect3);
                rect4 = addRectangle(pivotX + 1, pivotY);
                rect3 = addRectangle(pivotX - 1, pivotY - 1);
                reassignRectangles();
                angle = 0;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of Bounds");
        }
    } //rotateTo0
} //ZShape class
