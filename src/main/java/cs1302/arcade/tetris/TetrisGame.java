package cs1302.arcade.tetris;

import cs1302.arcade.ArcadeApp;
import javafx.scene.*;
import javafx.scene.text.*;

public class TetrisGame {
    private ArcadeApp arcadeApp;
    private int points = 0;
    private Text score = new Text();
    private Scene scene;

    //sets up main menu
    private void mainMenu() {
	arcadeApp.stage.setScene(arcadeApp.mainMenu());
    } //mainMenu

    //updates score
    private void scoreUpdate() {
	String str = "Score: " + points;
	score.setText(str);
    } //scoreUpdate
} //TetrisGame
    
