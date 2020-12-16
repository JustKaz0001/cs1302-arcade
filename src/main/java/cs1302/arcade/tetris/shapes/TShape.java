package cs1302.arcade.tetris.shapes;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

/**
 * Creates a T shape in Tetris.
 */
public class TShape extends Shape {
    
    /**
     * Sets al of the aspects for a T Shape object.
     * @param gridP a reference to the {@code GridPane} that contains the {@code Rectangle} objects
     */
    public TShape(GridPane gridP) {
        super(1, gridP, Color.PURPLE);
        pivotX = (int)(Math.random() * 8) + 1; //random int from 1 tp 8
        rect1 = addRectangle(pivotX, pivotY);
        rect2 = addRectangle(pivotX, pivotY - 1);
        rect3 = addRectangle(pivotX + 1, pivotY);
        rect4 = addRectangle(pivotX - 1, pivotY);
                
        reassignRectangles();
    } //TShape method

    /** {@inheritDoc} */
    public void rotateTo270() {
        int y = pivotY - 1;
        int x = pivotX;
        try {
            Rectangle rectNext = getFromGrid(x, y);
            if (rectNext == null) {
                removeRectangle(rect3);
                rect3 = addRectangle(x, y);
                rectangles[2] = rect3;
                angle = 270;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo270

    /** {@inheritDoc} */
    public void rotateTo180() {
        //Rotates shapes accordingly
        int y = pivotY;
        int x = pivotX - 1;
        try {
            Rectangle rectNext = getFromGrid(x, y);
            if (rectNext == null) {
                removeRectangle(rect2);
                rect2 = addRectangle(x, y);
                rectangles[1] = rect2;
                angle = 180;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo180

    /** {@inheritDoc} */
    public void rotateTo90() {
        //Rotates shapes accordingly
        int y = pivotY + 1;
        int x = pivotX;
        try {
            Rectangle rectNext = getFromGrid(x, y);
            if (rectNext == null) {
                removeRectangle(rect4);
                rect4 = addRectangle(x, y);    
                rectangles[3] = rect4;
                angle = 90;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    } //rotateTo90

     /** {@inheritDoc} */
    public void rotateTo0() {
        //Rotates shapes accordingly
        int y = pivotY;
        int x = pivotX + 1;
        try {
            Rectangle rectNext = getFromGrid(x, y);
            if (rectNext == null) {
                for (Rectangle r : rectangles) {
                    removeRectangle(r);
                }
                rect1 = addRectangle(pivotX, pivotY);
                rect2 = addRectangle(pivotX, pivotY - 1);
                rect3 = addRectangle(pivotX + 1, pivotY);
                rect4 = addRectangle(pivotX - 1, pivotY);            
                reassignRectangles();
                angle = 0;
            } //if
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
    }  //rotateTo0
} //TShape class
