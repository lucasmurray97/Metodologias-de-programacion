package com.example.aventurasdemarcoyluis.gui;

import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.model.Game.Game;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class App extends Application {
    private static final String RESOURCE_PATH = "src/main/resources/";
    private Game game;
    public static void main(String[] args) {
        launch(args);
    }
    Scene scene, marioScene;

    public void start(Stage primaryStage) throws Exception {
        int width = 1000;
        int height = 700;
        Group layout = new Group();
        Group layout2 = new Group();
        Group layout3 = new Group();
        Group layout4 = new Group();
        Group layout5 = new Group();
        Group layout6 = new Group();
        Scene newGameScene = new Scene(layout, width, height);
        Scene marioScene = new Scene(layout2, width, height);
        Scene luigiScene = new Scene(layout3, width, height);
        Scene goombaScene = new Scene(layout4, width, height);
        Scene booScene = new Scene(layout5, width, height);
        Scene spinyScene = new Scene(layout6, width, height);
        Button button = new Button("New Game");
        button.setOnAction(e -> {
            this.game = new Game();
            this.game.levelUp();
            this.game.createBattle();
            primaryStage.setScene(marioScene);
            String stats = this.game.getBattle().getMarcos().toString();
            Text marioStats = new Text (10, 55, stats);
            marioStats.setFont(Font.font ("Comic Sans MS", FontWeight.BOLD, 15));
            marioStats.setFill(Color.WHITE);
            layout2.getChildren().add(marioStats);
            this.game.chooseTargetMarcos((AttackableByMarcos) this.game.getCharacters().get(0));
        });
        button.setLayoutY(300);
        button.setLayoutX(450);
        Button button2 = new Button("Backwards");
        button2.setOnAction(e -> {
            primaryStage.setScene(luigiScene);
            String stats = this.game.getBattle().getLuigi().toString();
            Text luigiStats = new Text (10, 55, stats);
            luigiStats.setFont(Font.font ("Comic Sans MS", FontWeight.BOLD, 15));
            luigiStats.setFill(Color.WHITE);
            layout3.getChildren().add(luigiStats);
        });
        button2.setLayoutY(300);
        button2.setLayoutX(450);
        Button button3 = new Button("Backwards");
        button3.setOnAction(e -> {
            primaryStage.setScene(goombaScene);
        });
        button3.setLayoutY(300);
        button3.setLayoutX(450);
        Button button4 = new Button("Backwards");
        button4.setOnAction(e -> {
            primaryStage.setScene(booScene);
        });
        button4.setLayoutY(300);
        button4.setLayoutX(450);
        Button button5 = new Button("Backwards");
        button5.setOnAction(e -> {
            primaryStage.setScene(spinyScene);
        });
        button5.setLayoutY(300);
        button5.setLayoutX(450);
        Button button6 = new Button("Exit");
        button6.setOnAction(e -> {
            primaryStage.close();
        });
        button6.setLayoutY(300);
        button6.setLayoutX(450);
        var background = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background.jpg")));
        var background2 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background.jpg")));
        var background3 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background.jpg")));
        var background4 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background.jpg")));
        var background5 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background.jpg")));
        var background6 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background.jpg")));
        Image marioImage = new Image(new FileInputStream(RESOURCE_PATH + "mario.jpg"));
        var mario = new ImageCursor(marioImage, marioImage.getWidth(), marioImage.getHeight());
        Image luigiImage = new Image(new FileInputStream(RESOURCE_PATH + "luigi.png"));
        var luigi = new ImageCursor(luigiImage, luigiImage.getWidth(), luigiImage.getHeight());
        Image goombaImage = new Image(new FileInputStream(RESOURCE_PATH + "goomba.png"));
        var goomba = new ImageCursor(goombaImage, goombaImage.getWidth(), goombaImage.getHeight());
        Image booImage = new Image(new FileInputStream(RESOURCE_PATH + "boo.png"));
        var boo = new ImageCursor(booImage, booImage.getWidth(), booImage.getHeight());
        Image spinyImage = new Image(new FileInputStream(RESOURCE_PATH + "spiny.jpg"));
        var spiny = new ImageCursor(spinyImage, spinyImage.getWidth(), spinyImage.getHeight());
        Text welcome = new Text (10, 30, "Welcome to Mario and Luigi adventures!");
        welcome.setFont(Font.font ("Comic Sans MS", FontWeight.BOLD, 30));
        welcome.setFill(Color.WHITE);
        Text marioText = new Text (10, 30, "It's Mario's Turn!");
        marioText.setFont(Font.font ("Comic Sans MS", FontWeight.BOLD, 30));
        marioText.setFill(Color.WHITE);
        Text luigiText = new Text (10, 30, "It's Luigi's Turn!");
        luigiText.setFont(Font.font ("Comic Sans MS", FontWeight.BOLD, 30));
        luigiText.setFill(Color.WHITE);
        layout.getChildren().add(background);
        layout2.getChildren().add(background2);
        layout3.getChildren().add(background3);
        layout4.getChildren().add(background4);
        layout5.getChildren().add(background5);
        layout6.getChildren().add(background6);
        marioScene.setCursor(mario);
        luigiScene.setCursor(luigi);
        goombaScene.setCursor(goomba);
        booScene.setCursor(boo);
        spinyScene.setCursor(spiny);
        layout.getChildren().add(button);
        layout2.getChildren().add(button2);
        layout3.getChildren().add(button3);
        layout4.getChildren().add(button4);
        layout5.getChildren().add(button5);
        layout6.getChildren().add(button6);
        layout.getChildren().add(welcome);
        layout2.getChildren().add(marioText);
        layout3.getChildren().add(luigiText);
        primaryStage.setTitle("Mario and Luigi");
        primaryStage.setScene(newGameScene);
        primaryStage.show();
    }
}

