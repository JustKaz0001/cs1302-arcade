package cs1302.arcade;

import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

import javafx.scene.control.Labeled;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.text.*;
import javafx.geometry.Orientation;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.scene.layout.CornerRadii;
import javafx.scene.*;
import cs1302.arcade.tetris.*;
import javafx.scene.control.Separator;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;

/**
 * Application subclass for {@code ArcadeApp}.
 * @version 2019.fa
 */
public class ArcadeApp extends Application {
    public Stage stage;

     /**
     *Start method to include the title and scene.
     * @param stage Stage displays it
     */
    public void start(Stage stage) {
        //sets stage to param
        this.stage = stage;
        stage.setTitle("cs1302-arcade!");
        stage.setScene(mainMenu());
        stage.sizeToScene();
        stage.show();
    } //start

    /**
     * Makess the main menu.
     * @return a {@code Scene} for the main menu
     */
    public Scene mainMenu() {
        //sets buttons and images
        Button b1 = new Button();
        TetrisGame gameTetris = new TetrisGame();
        ImageView iv1 = new ImageView(new Image("https://www.google.com/url?sa=i&url=https%3A%2F%2Fnintendo.fandom.com%2Fwiki%2FTetris&psig=AOvVaw3hHvqQLUNuZ_HfScD9sO79&ust=1608213306553000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLjW8MjT0u0CFQAAAAAdAAAAABAD"));

        //sets dimensions for images
        iv1.setFitWidth(305);
        iv1.setPreserveRatio(true);
        b1.setGraphic(iv1);
        b1.setOnAction(e -> stage.setScene(gameTetris.getScene(this)));                 

        //colors exit button and makes it red
        Button exit = new Button("Exit");
        exit.setMinWidth(100);
        exit.setStyle("-fx-background-color: Red");
        exit.setOnAction(e -> System.exit(0));
        HBox buttons = new HBox(b1);

        //new pane for all buttons
        VBox newPane = new VBox(buttons, exit);
        BackgroundFill bf = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        newPane.setBackground(new Background(bf));
        newPane.setPadding(new Insets(10, 10, 10, 10));  
        newPane.setSpacing(10);
        Scene scene = new Scene(newPane, 560, 275);
        return scene;
    }
    
    /**
     * Displays the menu.
     */
    public void setSceneToMenu() {
        //stages and sets scene
        stage.setScene(mainMenu());
    }
} // ArcadeApp
