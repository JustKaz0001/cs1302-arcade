package cs1302.arcade.tetris;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 *Creates an Element containing 4 rectangles {@code Rectangle}.
 */
public class Element {
    //assigns color and boolean
    Color colorBlock;
    boolean clearTF;
    //4 different rectangles
    public static Rectangle rec1;
    public static Rectangle rec2;
    public static Rectangle rec3;
    public static Rectangle rec4;

    /**
     * Assigns input to variables of rec.
     * @param rec1 rectangle 1
     * @param rec2 rectangle 2 
     * @param rec3 rectangle 3
     * @param rec4 rectangle 4
     */
    public Element(Rectangle rec1, Rectangle rec2, Rectangle rec3, Rectangle rec4) {
        this.rec1 = rec1;
        this.rec2 = rec2;
        this.rec3 = rec3;
        this.rec4 = rec4;
    } //Element 4 param

    /**
     *Constructor with no parameter.
     */
    public Element() {
        clearTF = true;
    } //Element no param

    /**
     *Represents empty element.
     */
    public void emptyElem() {
        clearTF = true;
    } //emptyElem

    /**
     *Fills in color of element.
     * @param color takes in color to fill
     */
    public void elemFill(String color) {
        //makes them blue
        if (color.equalsIgnoreCase("blue")) {
            colorBlock = Color.BLUE;
        }
        //sets the filler color
        rec1.setFill(colorBlock);
        rec2.setFill(colorBlock);
        rec3.setFill(colorBlock);
        rec4.setFill(colorBlock);
    } //elemFill
} //Element class
