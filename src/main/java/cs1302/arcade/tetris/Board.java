package cs1302.arcade.tetris;

import cs1302.arcade.tetris.*;
import javafx.scene.shape.Rectangle;

public class Board {

    private boolean gameOver = false;
    //initializing length width and dimensions 
    int sizeBlock = 30;
    int gameWidth = 300;
    int gameLength = 600;
    int distDown = 30;

    //grid for the overall game
    int [][] grid = new int[gameWidth/sizeBlock][gameLength/sizeBlock];

    private Rectangle[][] board;

    public static Element boardGenerator() {
	int numShape = 1;
	Rectangle elem1 = new Rectangle(29, 29);
	Rectangle elem2 = new Rectangle(29, 29);
	Rectangle elem2 = new Rectangle(29, 29);
	Rectangle elem4 = new Rectangle(30, 30);
	if (numShape == 1) {
	    elem1.setX(300/2+20);
	    elem2.setX(150-30);
	    elem2.setY(30);
	    elem3.setX(150);
	    elem3.setY(30);
	    elem4.setX(150+30);
	    elem4.setY(30);
	}
	return new Element(elem1, elem2, elem3, elem4);
    } //boardGenerator
    
} //Board
