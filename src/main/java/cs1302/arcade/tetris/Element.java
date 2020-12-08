package cs1302.arcade.tetris;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Element {

    Color colorBlock;
    boolean clearTF;
    public static Rectangle rec1;
    public static Rectangle rec2;
    public static Rectangle rec3;
    public static Rectangle rec4;

    public Element(Rectangle rec1, Rectangle rec2, Rectangle rec3, Rectangle rec4) {
	this.rec1 = rec1;
	this.rec2 = rec2;
	this.rec3 = rec3;
	this.rec4 = rec4;
    } //Element 4 param
    
    public Element() {
	clearTF = true;
    } //Element no param

    public void emptyElem() {
	clearTF = true;
    } //emptyElem

    public void ElemFill(String color) {
	if (color.equalsIgnoreCase("blue")) {
	    colorBlock = Color.BLUE;
	}
	rec1.setFill(colorBlock);
	rec2.setFill(colorBlock);
	rec3.setFill(colorBlock);
	rec4.setFill(colorBlock);
    } //elemFill
} //Element class
