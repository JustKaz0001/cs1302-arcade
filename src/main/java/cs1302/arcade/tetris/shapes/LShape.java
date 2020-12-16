package cs1302.arcade.tetris.shapes;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 *Creates an L shape.
 */
public class LShape extends Shape {
    /**
     * Makes L Shape.
     * @param gridP a reference to the {@code GridPane} storing {@code Rectangle} objects
     */
    public LShape(GridPane gridP) {
        super(1, gridP, Color.ORANGE);
        pivotX = (int)(Math.random() * 8) + 1;
        //pivots in a way to make an L       
        rect1 = addRectangle(pivotX, pivotY);
        rect2 = addRectangle(pivotX + 1, pivotY);
        rect3 = addRectangle(pivotX + 1, pivotY - 1);
        rect4 = addRectangle(pivotX - 1, pivotY);
        
        reassignRectangles();
    }

    /** {@inheritDoc} */
    public void rotateTo270() {
        try {
            Rectangle nRect4 = getFromGrid(pivotX, pivotY + 1);
            Rectangle nRect2 = getFromGrid(pivotX, pivotY - 1);
            Rectangle nRect3 = getFromGrid(pivotX - 1, pivotY - 1);
            if (nRect4 == null && nRect2 == null && nRect3 == null) {
                removeRectangle(rect4);
                removeRectangle(rect2);
                removeRectangle(rect3);
                rect4 = addRectangle(pivotX, pivotY + 1);
                rect2 = addRectangle(pivotX, pivotY - 1);
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
        try {
            Rectangle nRect4 = getFromGrid(pivotX + 1, pivotY);
            Rectangle nRect2 = getFromGrid(pivotX - 1, pivotY);
            Rectangle nRect3 = getFromGrid(pivotX - 1, pivotY + 1);
            if (nRect4 == null && nRect2 == null && nRect3 == null) {
                removeRectangle(rect4);
                removeRectangle(rect2);
                removeRectangle(rect3);
                rect4 = addRectangle(pivotX + 1, pivotY);
                rect2 = addRectangle(pivotX - 1, pivotY);
                rect3 = addRectangle(pivotX - 1, pivotY + 1);
                reassignRectangles();
                angle = 180;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo180
    
    /** {@inheritDoc} */
    public void rotateTo90() {
        try {
            Rectangle nRect4 = getFromGrid(pivotX, pivotY - 1);
            Rectangle nRect2 = getFromGrid(pivotX, pivotY + 1);
            Rectangle nRect3 = getFromGrid(pivotX + 1, pivotY + 1);
            if (nRect4 == null && nRect2 == null && nRect3 == null) {
                removeRectangle(rect4);
                removeRectangle(rect2);
                removeRectangle(rect3);
                rect4 = addRectangle(pivotX, pivotY - 1);
                rect2 = addRectangle(pivotX, pivotY + 1);
                rect3 = addRectangle(pivotX + 1, pivotY + 1);
                reassignRectangles();
                angle = 90;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo90

    /** {@inheritDoc} */
    public void rotateTo0() {
        try {
            Rectangle nRect4 = getFromGrid(pivotX - 1, pivotY);
            Rectangle nRect2 = getFromGrid(pivotX + 1, pivotY);
            Rectangle nRect3 = getFromGrid(pivotX + 1, pivotY - 1);
            if (nRect4 == null && nRect2 == null && nRect3 == null) {
                removeRectangle(rect4);
                removeRectangle(rect2);
                removeRectangle(rect3);
                rect4 = addRectangle(pivotX - 1, pivotY);
                rect2 = addRectangle(pivotX + 1, pivotY);
                rect3 = addRectangle(pivotX + 1, pivotY - 1);
                reassignRectangles();
                angle = 0;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo0
} //LShape
