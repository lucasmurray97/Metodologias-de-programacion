/**
package com.example.aventurasdemarcoyluis.gui;

package com.example.aventurasdemarcoyluis.gui;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.model.Game.Game;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Scene;

public class PorMientras extends Application {
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
        ImageNodeBuilder newGameBuilder = new ImageNodeBuilder(newGameScene);
        ImageView newgame = newGameBuilder.build(450, 300, 100, 100, RESOURCE_PATH, "newgame.jpg");
        newgame.setPickOnBounds(true);
        newgame.setOnMouseClicked((MouseEvent e) -> {
            this.game = new Game();
            this.game.addRedMushroom(3);
            this.game.addHoneySyrup(3);
            this.game.createBattle(4);
            primaryStage.setScene(marioScene);
            String stats = this.game.getBattle().getMarcos().toString() + ", fp: " +this.game.getBattle().getMarcos().getFp();
            Text marioStats = new Text(10, 55, stats);
            marioStats.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
            marioStats.setFill(Color.WHITE);
            layout2.getChildren().add(marioStats);
            try {
                showCharacters(marioScene, layout2);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            try {
                showItems(marioScene, layout2);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        Button button2 = new Button("Backwards");
        button2.setOnAction(e -> {
            primaryStage.setScene(luigiScene);
            String stats = this.game.getBattle().getLuigi().toString();
            Text luigiStats = new Text(10, 55, stats);
            luigiStats.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
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
        button3.setLayoutX(500);
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
        Text welcome = new Text(10, 30, "Welcome to Mario and Luigi adventures!");
        welcome.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        welcome.setFill(Color.WHITE);
        Text marioText = new Text(10, 30, "It's Mario's Turn!");
        marioText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        marioText.setFill(Color.WHITE);
        Text luigiText = new Text(10, 30, "It's Luigi's Turn!");
        luigiText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        luigiText.setFill(Color.WHITE);
        layout.getChildren().add(background);
        layout2.getChildren().add(background2);
        addCenterText(layout2);
        layout3.getChildren().add(background3);
        layout4.getChildren().add(background4);
        layout5.getChildren().add(background5);
        layout6.getChildren().add(background6);
        layout.getChildren().add(newgame);
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
    public void showCharacters(Scene escena, Group layout) throws FileNotFoundException {
        for (int i = 0; i < this.game.getCharacters().size(); i++) {
            String type = this.game.getCharacters().get(i).getType();
            if (type == "Marcos") {
                ImageNodeBuilder imageNodeBuilder = new ImageNodeBuilder(escena);
                layout.getChildren().add(imageNodeBuilder.build(100 + 100 * i, 500, 30, 30, RESOURCE_PATH, "mario.jpg"));
            }else if (type == "Luigi") {
                ImageNodeBuilder imageNodeBuilder = new ImageNodeBuilder(escena);
                ImageView image = imageNodeBuilder.build(100 + 100 * i, 500, 30, 30, RESOURCE_PATH, "luigi.png");
                layout.getChildren().add(image);
            } else if (type == "Goomba") {
                AttackableByMarcos character = (AttackableByMarcos) this.game.getCharacters().get(i);
                ImageNodeBuilder imageNodeBuilder = new ImageNodeBuilder(escena);
                ImageView image = imageNodeBuilder.build(100 + 100 * i, 500, 30, 30, RESOURCE_PATH, "goomba.png");
                image.setPickOnBounds(true);
                image.setOnMouseClicked((MouseEvent e) -> {
                    this.game.chooseTargetMarcos(character);
                    this.game.marcosJumpAttack();
                    System.out.println("Click");
                });
                layout.getChildren().add(image);
            } else if (type == "Boo") {
                ImageNodeBuilder imageNodeBuilder = new ImageNodeBuilder(escena);
                layout.getChildren().add(imageNodeBuilder.build(100 + 100 * i, 500, 30, 30, RESOURCE_PATH, "boo.png"));
            } else if (type == "Spiny") {
                ImageNodeBuilder imageNodeBuilder = new ImageNodeBuilder(escena);
                layout.getChildren().add(imageNodeBuilder.build(100 + 100 * i, 500, 30, 30, RESOURCE_PATH, "spiny.jpg"));
            }
        }
    }
    public void addCenterText(Group layout){
        Text centerMessage = new Text(200, 280,"");
        centerMessage.setAccessibleText("CenterMessage");
        centerMessage.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
        centerMessage.setFill(Color.BROWN);
        layout.getChildren().add(centerMessage);
    }
    public void showItems(Scene escena, Group layout) throws FileNotFoundException{
        Text items = new Text(50, 570, "Items:");
        items.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        items.setFill(Color.WHITE);
        layout.getChildren().add(items);
        for(int i=0; i< this.game.getItems().size(); i++){
            System.out.println(this.game.getItems().get(i).getName());
            if(this.game.getItems().get(i).getName()=="RedMushroom"){
                ImageNodeBuilder imageNodeBuilder = new ImageNodeBuilder(escena);
                ImageView image = imageNodeBuilder.build(100 + 100 * i, 600, 30, 30, RESOURCE_PATH, "mushroom.jpg");
                image.setOnMouseClicked((MouseEvent e) -> {
                    for(int j=0; j<layout.getChildren().size();j++){
                        if(layout.getChildren().get(j).getAccessibleText()=="centerMessage"){
                            layout.getChildren().remove(j);
                            Text message = new Text(200, 280,"You have chosen a Red Mushroom! Now choose either Luigi or Mario to use it on...");
                            message.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
                            message.setFill(Color.BROWN);
                            message.setAccessibleText("centerMessage");
                            layout.getChildren().add(message);
                        }
                    }
                });
                layout.getChildren().add(image);
            }else if (this.game.getItems().get(i).getName()=="HoneySyrup"){
                ImageNodeBuilder imageNodeBuilder = new ImageNodeBuilder(escena);
                ImageView image = imageNodeBuilder.build(100 + 100 * i, 600, 30, 30, RESOURCE_PATH, "honey.jpg");
                image.setOnMouseClicked((MouseEvent e) -> {
                    for(int j=0; j<layout.getChildren().size();j++){
                        if(layout.getChildren().get(j).getAccessibleText()=="centerMessage"){
                            layout.getChildren().remove(j);
                            Text message = new Text(200, 280,"You have chosen a Honey Syrup! Now choose either Luigi or Mario to use it on...");
                            message.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
                            message.setFill(Color.BROWN);
                            message.setAccessibleText("centerMessage");
                            layout.getChildren().add(message);
                        }
                    }
                });
                layout.getChildren().add(image);
            }
        }
    }
}
 */
