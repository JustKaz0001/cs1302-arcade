package cs1302.arcade.tetris.shapes;

import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

/**
 * Makes an I shape.
 */
public class IShape extends Shape {

    /**
     *Represents I shape using grid pane.
     * @param gridP gridpane to make the shapes
     */
    public IShape(GridPane gridP) {
        super(0, gridP, Color.DEEPSKYBLUE);
        pivotX = (int)(Math.random() * 7);

        //pivots each rect to make an I
        rect1 = addRectangle(pivotX, pivotY);
        rect2 = addRectangle(pivotX + 1, pivotY);
        rect3 = addRectangle(pivotX + 2, pivotY);
        rect4 = addRectangle(pivotX + 3, pivotY);

        reassignRectangles();
    } //IShape

    /** {@inheritDoc} */
    public void rotateTo270() {
        //rotates shape accordingly
        try {
            Rectangle nRect2 = getFromGrid(pivotX, pivotY - 1);
            Rectangle nRect3 = getFromGrid(pivotX, pivotY - 2);
            Rectangle nRect4 = getFromGrid(pivotX, pivotY - 3);
            if (nRect2 == null && nRect3 == null && nRect4 == null) {
                removeRectangle(rect2);
                removeRectangle(rect3);
                removeRectangle(rect4);
                rect2 = addRectangle(pivotX, pivotY - 1);
                rect3 = addRectangle(pivotX, pivotY - 2);
                rect4 = addRectangle(pivotX, pivotY - 3);
                reassignRectangles();
                angle = 270;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo270

    /** {@inheritDoc} */
    public void rotateTo180() {
        //rotates shape accordingly
        try {
            Rectangle nRect2 = getFromGrid(pivotX - 1, pivotY);
            Rectangle nRect3 = getFromGrid(pivotX - 2, pivotY);
            Rectangle nRect4 = getFromGrid(pivotX - 3, pivotY);
            if (nRect2 == null && nRect3 == null && nRect4 == null) {
                removeRectangle(rect2);
                removeRectangle(rect3);
                removeRectangle(rect4);
                rect2 = addRectangle(pivotX - 1, pivotY);
                rect3 = addRectangle(pivotX - 2, pivotY);
                rect4 = addRectangle(pivotX - 3, pivotY);
                reassignRectangles();
                angle = 180;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo180

     /** {@inheritDoc} */
    public void rotateTo90() {
        //Rotates shape accordinglt
        try {
            Rectangle nRect2 = getFromGrid(pivotX, pivotY + 1);
            Rectangle nRect3 = getFromGrid(pivotX, pivotY + 2);
            Rectangle nRect4 = getFromGrid(pivotX, pivotY + 3);
            if (nRect2 == null && nRect3 == null && nRect4 == null) {
                removeRectangle(rect2);
                removeRectangle(rect3);
                removeRectangle(rect4);
                rect2 = addRectangle(pivotX, pivotY + 1);
                rect3 = addRectangle(pivotX, pivotY + 2);
                rect4 = addRectangle(pivotX, pivotY + 3);
                reassignRectangles();
                angle = 90;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo90

    /** {@inheritDoc} */
    public void rotateTo0() {
        //rotates shape acordingly
        try {
            Rectangle nRect2 = getFromGrid(pivotX + 1, pivotY);
            Rectangle nRect3 = getFromGrid(pivotX + 2, pivotY);
            Rectangle nRect4 = getFromGrid(pivotX + 3, pivotY);
            if (nRect2 == null && nRect3 == null && nRect4 == null) {
                removeRectangle(rect2);
                removeRectangle(rect3);
                removeRectangle(rect4);
                rect2 = addRectangle(pivotX + 1, pivotY);
                rect3 = addRectangle(pivotX + 2, pivotY);
                rect4 = addRectangle(pivotX + 3, pivotY);
                reassignRectangles();
                angle = 0;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo0
} //IShape
