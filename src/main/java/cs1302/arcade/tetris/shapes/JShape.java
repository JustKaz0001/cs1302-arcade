package cs1302.arcade.tetris.shapes;

import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *Rpresents a J shape by extending the shape class.
 */
public class JShape extends Shape {

    /**
     * Sets aspects for a J Shape.
     * @param gridP a reference to the {@code GridPane} that has {@code Rectangle} objects
     */
    public JShape(GridPane gridP) {
        super(1, gridP, Color.BLUE);
        pivotX = (int)(Math.random() * 8) + 1; //random int from 1 to 8
        //pivots in a way to make a J
        rect1 = addRectangle(pivotX, pivotY);
        rect2 = addRectangle(pivotX - 1, pivotY);
        rect3 = addRectangle(pivotX - 1, pivotY - 1);
        rect4 = addRectangle(pivotX + 1, pivotY);

        reassignRectangles();
    } //JShape

    /** {@inheritDoc} */
    public void rotateTo270() {
        //Rotates shapes accordingly
        try {
            Rectangle nRect4 = getFromGrid(pivotX, pivotY - 1);
            Rectangle nRect2 = getFromGrid(pivotX, pivotY + 1);
            Rectangle nRect3 = getFromGrid(pivotX - 1, pivotY + 1);
            if (nRect4 == null && nRect2 == null && nRect3 == null) {
                removeRectangle(rect4);
                removeRectangle(rect2);
                removeRectangle(rect3);
                rect4 = addRectangle(pivotX, pivotY - 1);
                rect2 = addRectangle(pivotX, pivotY + 1);
                rect3 = addRectangle(pivotX - 1, pivotY + 1);
                reassignRectangles();
                angle = 270;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo270

    /** {@inheritDoc} */
    public void rotateTo180() {
        //Rotates the shape accordingly
        try {
            Rectangle nRect4 = getFromGrid(pivotX - 1, pivotY);
            Rectangle nRect2 = getFromGrid(pivotX + 1, pivotY);
            Rectangle nRect3 = getFromGrid(pivotX + 1, pivotY + 1);
            if (nRect4 == null && nRect2 == null && nRect3 == null) {
                removeRectangle(rect4);
                removeRectangle(rect2);
                removeRectangle(rect3);
                rect4 = addRectangle(pivotX - 1, pivotY);
                rect2 = addRectangle(pivotX + 1, pivotY);
                rect3 = addRectangle(pivotX + 1, pivotY + 1);
                reassignRectangles();
                angle = 180;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo180

    /** {@inheritDoc} */
    public void rotateTo90() {
        //Rotates shapes accordingly
        try {
            Rectangle nRect4 = getFromGrid(pivotX, pivotY + 1);
            Rectangle nRect2 = getFromGrid(pivotX, pivotY - 1);
            Rectangle nRect3 = getFromGrid(pivotX + 1, pivotY - 1);
            if (nRect4 == null && nRect2 == null && nRect3 == null) {
                removeRectangle(rect4);
                removeRectangle(rect2);
                removeRectangle(rect3);
                rect4 = addRectangle(pivotX, pivotY + 1);
                rect2 = addRectangle(pivotX, pivotY - 1);
                rect3 = addRectangle(pivotX + 1, pivotY - 1);
                reassignRectangles();
                angle = 90;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo90

     /** {@inheritDoc} */
    public void rotateTo0() {
        //Rotates shapes accordingly
        try {
            Rectangle nRect4 = getFromGrid(pivotX + 1, pivotY);
            Rectangle nRect2 = getFromGrid(pivotX - 1, pivotY);
            Rectangle nRect3 = getFromGrid(pivotX - 1, pivotY - 1);
            if (nRect4 == null && nRect2 == null && nRect3 == null) {
                removeRectangle(rect4);
                removeRectangle(rect2);
                removeRectangle(rect3);
                rect4 = addRectangle(pivotX + 1, pivotY);
                rect2 = addRectangle(pivotX - 1, pivotY);
                rect3 = addRectangle(pivotX - 1, pivotY - 1);
                reassignRectangles();
                angle = 0;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo0
} //JShape
