package cs1302.arcade.tetris.shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;

/**
 * Makes a S shape for Tetris.
 */
public class SShape extends Shape {

    /**
     * Sets the aspects for a S Shape.
     * @param gridP a reference to the {@code GridPane} that has the {@code Rectangle} objects
     */
    public SShape(GridPane gridP)  {
        super(1, gridP, Color.GREEN);
        pivotX = (int)(Math.random() * 8) + 1; //random from 1 to8
        //pivots in a way to make an S
        rect1 = addRectangle(pivotX, pivotY);
        rect2 = addRectangle(pivotX, pivotY - 1);
        rect3 = addRectangle(pivotX + 1, pivotY - 1);
        rect4 = addRectangle(pivotX - 1, pivotY);

        reassignRectangles();
    } //SShape method

    /** {@inheritDoc} */
    public void rotateTo270() {
        //Rotates shapes accordingly
        try {
            Rectangle nRect4 = getFromGrid(pivotX - 1, pivotY);
            Rectangle nRect3 = getFromGrid(pivotX - 1, pivotY - 1);
            if (nRect4 == null && nRect3 == null) {
                removeRectangle(rect4);
                removeRectangle(rect3);
                rect4 = addRectangle(pivotX - 1, pivotY);
                rect3 = addRectangle(pivotX - 1, pivotY - 1);
                reassignRectangles();
                angle = 270;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo270

    /** {@inheritDoc} */
    public void rotateTo180() {
        //Rotates shapes accordingly
        try {
            Rectangle nRect4 = getFromGrid(pivotX - 1, pivotY + 1);
            Rectangle nRect2 = getFromGrid(pivotX, pivotY + 1);
            if (nRect4 == null && nRect2 == null) {
                removeRectangle(rect4);
                removeRectangle(rect2);
                rect4 = addRectangle(pivotX - 1, pivotY + 1);
                rect2 = addRectangle(pivotX, pivotY + 1);
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
            Rectangle nRect4 = getFromGrid(pivotX + 1, pivotY + 1);
            Rectangle nRect3 = getFromGrid(pivotX + 1, pivotY);
            if (nRect4 == null && nRect3 == null) {
                removeRectangle(rect4);
                removeRectangle(rect3);
                rect4 = addRectangle(pivotX + 1, pivotY + 1);
                rect3 = addRectangle(pivotX + 1, pivotY);
                reassignRectangles();
                angle = 90;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo90

    /** {@inheritDoc} */
    public void rotateTo0() {
        //Rotates shapes accordinglty
        try {
            Rectangle nRect2 = getFromGrid(pivotX, pivotY - 1);
            Rectangle nRect3 = getFromGrid(pivotX + 1, pivotY - 1);
            if (nRect2 == null && nRect3 == null) {
                removeRectangle(rect2);
                removeRectangle(rect3);
                rect2 = addRectangle(pivotX, pivotY - 1);
                rect3 = addRectangle(pivotX + 1, pivotY - 1);
                reassignRectangles();
                angle = 0;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo0
} //SShape class
