package cs1302.arcade.tetris;

import cs1302.arcade.ArcadeApp;
import cs1302.arcade.tetris.shapes.*;

import java.util.Arrays;
import javafx.util.Duration;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.application.Platform;

import javafx.scene.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.layout.*;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * Represents a game using various java files to pull of actions and display a game.
 */
public class TetrisGame {
    //sets all variables
    private ArcadeApp arcApp;
    private Timeline timeL = new Timeline();
    private Shape currentShape;
    private int points = 0;
    private Text score = new Text();
    private Text lvl = new Text();
    private GridPane gridP = new GridPane();
    private boolean gameOver = false;
    private Scene scene;

    /**sets up main menu. */
    private void mainMenu() {
        arcApp.stage.setScene(arcApp.mainMenu());
    } //mainMenu

    /** updates score. */
    private void scoreUpdate() {
        String str = "Score: " + points;
        score.setText(str); //sets score
    } //scoreUpdate

    /** Gets start scene.
     * @param a ArcadeApp to get the scene
     * @return Scene with all the information 
     */
    public Scene getScene(ArcadeApp a) {
        //updates score and sets a
        scoreUpdate();
        arcApp = a;
        //different font sizes
        lvl.setFont(new Font(20));
        score.setFont(new Font(20));
        HBox allScores = new HBox(score, lvl);
        allScores.setSpacing(30);

        //sets 2 buttons
        Button button = new Button("New Game") {
                public void requestFocus() { } 
            };
        button.setOnAction(e -> newGame());
        Button button2 = new Button("Back to Game Menu") {
                public void requestFocus() { }
            };
        //sets all buttons in Boxes
        button2.setOnAction(e -> mainMenu());
        HBox allButts = new HBox(button, button2);
        VBox vbox = new VBox(allScores, allButts, gridP);
        scene = new Scene(vbox);
        gridP.requestFocus();
        newGame();
        gridP.setOnKeyPressed(keyHandleCreater());

        return scene;
    } //getScene

    /** Starts a new game. */
    private void newGame() {
        //remaking grid
        for (int row = 0; row < 20; row++) {
            for (int column = 0; column < 10; column++) {
                for (int i = 0; i < 2; i++) {
                    if (fromGrid(column, row) != null) {
                        gridP.getChildren().remove(fromGrid(column, row));
                    }
                }
            }
        }
        //restarting evrything
        gridNew();
        scoreUpdate();
        lvl.setText("Level: 1");
        newShape();
        setTL(1);
        gameOver = false;
        points = 0;
        timeL.play();
    } //newGame

    /** Updates level after certain points. */
    private void lvlUpdate() {
        //updates lvl based on points only 2 levels
        if (points >= 200) {
            setTL(2);
            timeL.play();
            lvl.setText("Level: 2");
        } else if (points >= 200) {
            setTL(3);
            timeL.play();
            lvl.setText("Level: 3");
        }
    } //updatLvl

    /** adds points each time. 
     * @param lines integer number of lines
     */
    private void pointAdd(int lines) {
        //adds points as more lines are covered
        if (lines == 4) {
            points += 1200;
        } else if (lines == 3) {
            points += 300;
        } else if (lines == 2) {
            points += 100;
        } else if (lines == 1) {
            points += 40;
        }
        //updates score adn level
        scoreUpdate();
        lvlUpdate();
    } //pointAdd

    /** Sets Timeline depending on how game goes and if its over.
     * @param level int the num of level
     */
    private void setTL(int level) {
        timeL.stop();
        //after moving down bring a new shape stops timeline
        EventHandler<ActionEvent> handler = e -> {
            if (currentShape.moveDown() == false) {
                linesCleared();
                gameOverCheck();
                if (gameOver == false) {
                    newShape();
                } //if
            } //if
        }; //event handler
        KeyFrame kf;
        switch (level) {
            //switch to wait how long till next shape
        case 1:
            kf = new KeyFrame(Duration.millis(800), handler);
            break;
        case 2:
            kf = new KeyFrame(Duration.millis(500), handler);
            break;
        case 3:
            kf = new KeyFrame(Duration.millis(200), handler);
            break;
        default:
            kf = new KeyFrame(Duration.millis(1000), handler);
        } //switch
        timeL.getKeyFrames().clear();
        timeL.getKeyFrames().add(kf);
        timeL.setCycleCount(Timeline.INDEFINITE);
    } //setTl

    /** checks if game is over. */
    private void gameOverCheck() {
        //if columns finished
        for (int column = 0; column < 0; column++) {
            if (fromGrid(column, 0) != null) {
                timeL.stop();
                gameOver = true;
                //alert to replay by user
                Alert alertMess = new Alert(AlertType.INFORMATION,
                                            "GAME OVER. New Game to replay. \n" +
                                            "Final Score: " + points);
                Runnable run = () -> alertMess.showAndWait()
                    .filter(response -> response == ButtonType.OK);
                Platform.runLater(run);
                return;
            } //if
        } //for
    } //gameOverCheck

    /** Cleared all lines. */
    private void linesCleared() {
        int clearRow = 0;
        //clears all
        for (int y = 0; y < 20; y++) {
            boolean full = true;
            for (int x = 0; x < 10; x++) {
                if (fromGrid(x, y) == null) {
                    full = false;
                } //if
            } //for
            //clears even if full
            if (full) {
                clearRow++;
                for (int x = 0; x < 10; x++) {
                    Rectangle rec = fromGrid(x, y);
                    gridP.getChildren().remove(rec);
                    for (int z = y; z > 0; z--) {
                        Rectangle topRec = fromGrid(x, z - 1);
                        if (topRec != null) {
                            GridPane.setRowIndex(topRec, z);
                        } //if
                    } //for
                } //for
            } //if
        } //for
        pointAdd(clearRow);
    } //linesCleared

    /** makes a new grid. */
    private void gridNew() {
        //new grid of same size
        gridP.setPrefSize(300, 600);
        gridP.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        final int rowsNum = 20;
        final int columnsNum = 10;

        //resets rows
        for (int i = 0; i < rowsNum; i++) {
            RowConstraints constRow = new RowConstraints();
            constRow.setPercentHeight(100.0 / rowsNum);
            gridP.getRowConstraints().add(constRow);         
        } //for
        //resets columns
        for (int i = 0; i < columnsNum; i++) {
            ColumnConstraints constCol = new ColumnConstraints();
            constCol.setPercentWidth(100.0 / columnsNum);
            gridP.getColumnConstraints().add(constCol);
        } //for
        gridP.setGridLinesVisible(true);
    } //gridNew

    /** Gets specified rectangle from grid.
     * @param column number of column of rectangle on grid
     * @param row number of row of rect on grid
     * @return Rectangle with column and row int
     */
    public Rectangle fromGrid(int column, int row) {
        //node to see col and row on the grid pane
        for (Node node : gridP.getChildren()) {
            if (node != null && GridPane.getColumnIndex(node) != null
                && GridPane.getRowIndex(node) != null) {
                if (GridPane.getColumnIndex(node) == column && GridPane.getRowIndex(node) == row) {
                    return (Rectangle)node;
                } //if
            } //if
        } //for
        return null;
    } //fromGrid

    /** Handles the 4 arrow keys and assigns actions. 
     * @return EventHandler handles event of keys
     */
    private EventHandler<? super KeyEvent> keyHandleCreater() {
        return e -> {
            //uses key arrows and assigns actions to them for movement
            if (gameOver == false) {
                if (e.getCode() == KeyCode.DOWN) {
                    currentShape.moveToBottom();
                } else if (e.getCode() == KeyCode.UP) {
                    currentShape.rotate();
                } else if (e.getCode() == KeyCode.LEFT) {
                    currentShape.moveLeft();
                } else if (e.getCode() == KeyCode.RIGHT) {
                    currentShape.moveRight();
                } //if
            } //if
        }; //return
    } //keyHandleCreater

    /** Chooses a random shape. */
    private void newShape() {
        String[] allShapes = {"T","Square", "I", "J", "S", "L", "Z"};
        String shape = allShapes[(int)(Math.random() * 7)];
        switch (shape) {
            //uses the shapes and randomly chooses them
        case "T":
            currentShape = new TShape(gridP);
            break;
        case "Square":
            currentShape = new Square(gridP);
            break;
        case "I":
            currentShape = new IShape(gridP);
            break;
        case "J":
            currentShape = new JShape(gridP);
            break;
        case "S":
            currentShape = new SShape(gridP);
            break;
        case "L":
            currentShape = new LShape(gridP);
        case "Z":
            currentShape = new ZShape(gridP);
            break;
        default:
            currentShape = new Square(gridP);
            break;
        } //switch
    } //newShape
    
} //TetrisGame
