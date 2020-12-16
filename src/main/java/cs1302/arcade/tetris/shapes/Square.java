package cs1302.arcade.tetris.shapes;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 *A square represnted by using Shape class.
 */
public class Square extends Shape {

    /**
     * Create a square object and make it yellow.
     * @param gridP GridPane to make square 
     */
    public Square(GridPane gridP) {
        super(0, gridP, Color.YELLOW);
        pivotX = (int)(Math.random() * 9);
        //pivots in a way to make a square
        rect1 = addRectangle(pivotX, pivotY);
        rect2 = addRectangle(pivotX + 1, pivotY);
        rect3 = addRectangle(pivotX, pivotY + 1);
        rect4 = addRectangle(pivotX + 1, pivotY + 1);
        reassignRectangles();
    } //Square

    //doesnt need rotations because its a square
    /** Rotates 270. */
    public void rotateTo270() {}

    /**Rotates 180. */
    public void rotateTo180() {}

    /**Rotates 90. */
    public void rotateTo90() {}

    /**Rotates 0. */
    public void rotateTo0() {}


} //Square Class
