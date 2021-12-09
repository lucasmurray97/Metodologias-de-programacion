package com.example.aventurasdemarcoyluis.gui;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;
import com.example.aventurasdemarcoyluis.model.Game.Game;
import com.example.aventurasdemarcoyluis.model.Items.Item;
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

public class App extends Application {
    private static final String RESOURCE_PATH = "src/main/resources/";
    private Game game;
    int width = 1000;
    int height = 700;
    int gameCount = 0;
    Group gameOverLayout = new Group();
    Group marioChooseLayout = new Group();
    Group marioChooseItemLayout= new Group();
    Group marioChoosePlayerLayout= new Group();
    Group marioChooseVictimLayout= new Group();
    Group marioChooseAttackLayout= new Group();
    Group luigiChooseLayout =new Group();
    Group luigiChooseItemLayout= new Group();
    Group luigiChoosePlayerLayout= new Group();
    Group luigiChooseVictimLayout= new Group();
    Group luigiChooseAttackLayout= new Group();
    Scene gameOverScene = new Scene(gameOverLayout);
    Scene marioChooseScene = new Scene(marioChooseLayout);
    Scene marioChooseItemScene= new Scene(marioChooseItemLayout);
    Scene marioChoosePlayerScene= new Scene(marioChoosePlayerLayout);
    Scene marioChooseVictimScene= new Scene(marioChooseVictimLayout);
    Scene marioChooseAttackScene= new Scene(marioChooseAttackLayout);
    Scene luigiChooseScene = new Scene(luigiChooseLayout);
    Scene luigiChooseItemScene= new Scene(luigiChooseItemLayout);
    Scene luigiChoosePlayerScene= new Scene(luigiChoosePlayerLayout);
    Scene luigiChooseVictimScene= new Scene(luigiChooseVictimLayout);
    Scene luigiChooseAttackScene= new Scene(luigiChooseAttackLayout);

    public static void main(String[] args) {
        launch(args);
    }
    public void createbasicLayoutMain(Group layout,Scene scene) throws FileNotFoundException {
        layout.getChildren().removeAll();
        ImageNodeBuilder backgroundBuilder = new ImageNodeBuilder(scene);
        ImageView background = backgroundBuilder.build(0, 0,width , height, RESOURCE_PATH, "background2.jpg");
        Text marioText = new Text(10, 30, "It's "+ this.game.getCurrentPlayer().getType()+"'s turn!");
        marioText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        marioText.setFill(Color.WHITE);
        Text playersText = new Text(20, 70, "Players:");
        playersText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        playersText.setFill(Color.VIOLET);
        Text enemiesText = new Text(20, 180, "Enemies:");
        enemiesText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        enemiesText.setFill(Color.VIOLET);
        layout.getChildren().addAll(background, marioText, playersText, enemiesText);
        int j = 0;
        for (int i = 0; i<this.game.getCharacters().size(); i++){
            Character character = this.game.getCharacters().get(i);
            System.out.println(character);
            if(character.equals(this.game.getLuigi())){
                Text text = new Text(20, 95, character.toString()+", Fp: "+this.game.getLuigi().getFp());
                text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
                text.setFill(Color.GREENYELLOW);
                layout.getChildren().add(text);
            }else if(character.equals(this.game.getMarcos())){
                Text text = new Text(20, 125, character.toString()+", Fp: "+this.game.getMarcos().getFp());
                text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
                text.setFill(Color.GREENYELLOW);
                layout.getChildren().add(text);
            }else{
                Text text = new Text(20, 200+j*25, character.toString());
                text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
                text.setFill(Color.RED);
                layout.getChildren().add(text);
                j++;
            }
        }
    }
    public void showItems(Group layout, int y){
        Text itemsText = new Text(20, y, "Items:");
        itemsText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        itemsText.setFill(Color.VIOLET);
        layout.getChildren().add(itemsText);
        int j = 0;
        int w = 0;
        for(int i=0; i<this.game.getItems().size();i++){
            Item item = this.game.getItems().get(i);
            Text text;
            if(item.toString().equals("RedMushroom")){
                text = new Text(20, y+25 + j*25, item.toString());
                j++;
            }else {
                text = new Text(200, y+25 + w*25, item.toString());
                w++;
            }
            text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
            text.setFill(Color.YELLOW);
            layout.getChildren().add(text);
        }
    }
    public void createPlayerInterface(Stage primaryStage) throws FileNotFoundException {
        if(this.game.isInBattle()){
            Character currentCharacter = this.game.getCurrentPlayer();
            System.out.println(currentCharacter);
            if(currentCharacter.getType()=="Marcos"){
                createMariochoose(primaryStage);
            }else if(currentCharacter.getType()=="Luigi"){
                createLuigichoose(primaryStage);
            }else{
                this.game.normalAttack();
                System.out.println(this.game.getMarcos());
                System.out.println(this.game.getLuigi());
                createPlayerInterface(primaryStage);
            }
        }else if(this.game.Lost()){
            System.out.println("You Lost!");
            ImageNodeBuilder backgroundBuilder = new ImageNodeBuilder(gameOverScene);
            ImageView background = backgroundBuilder.build(0, 0,width , height, RESOURCE_PATH, "background2.jpg");
            ImageView gameover = backgroundBuilder.build(300, 220,400 , 200, RESOURCE_PATH, "gameover.png");
            gameOverLayout.getChildren().addAll(background,gameover);
            primaryStage.setScene(gameOverScene);
        }else if (this.game.hasWon()){

        }else{
            this.gameCount++;
            game.levelUp();
            game.addRedMushroom(1);
            game.addHoneySyrup(1);
            if(gameCount==1){
                this.game.createBattle(3);
            }else if(gameCount==2|gameCount==3){
                this.game.createBattle(5);
            }else{
                this.game.createBattle(6);
            }
            this.createPlayerInterface(primaryStage);
        }
    }
    public void createMariochoose(Stage primaryStage) throws FileNotFoundException {
        createbasicLayoutMain(marioChooseLayout, marioChooseScene);
        primaryStage.setScene(marioChooseScene);
        this.showItems(marioChooseLayout, 375);
        Button attack = new Button("Attack");
        Button useItem = new Button("Use Item");
        Button pass = new Button("Pass");
        attack.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        useItem.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        pass.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        attack.setLayoutX(150);
        attack.setLayoutY(600);
        useItem.setLayoutX(450);
        useItem.setLayoutY(600);
        pass.setLayoutX(800);
        pass.setLayoutY(600);
        attack.setOnMouseClicked((MouseEvent e) -> {
            try {
                createMarioAttack(primaryStage);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        useItem.setOnMouseClicked((MouseEvent e) -> {
            try {
                System.out.println("Chose an item");
                createMarioUseItem(primaryStage);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        pass.setOnMouseClicked((MouseEvent e) -> {
            this.game.terminate();
            try {
                createPlayerInterface(primaryStage);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        marioChooseLayout.getChildren().addAll(attack, useItem, pass);
    }

    private void createLuigichoose(Stage primaryStage) throws FileNotFoundException {
        createbasicLayoutMain(luigiChooseLayout, luigiChooseScene);
        primaryStage.setScene(luigiChooseScene);
        this.showItems(luigiChooseLayout, 375);
        Button attack = new Button("Attack");
        Button useItem = new Button("Use Item");
        Button pass = new Button("Pass");
        attack.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        useItem.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        pass.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        attack.setLayoutX(150);
        attack.setLayoutY(600);
        useItem.setLayoutX(450);
        useItem.setLayoutY(600);
        pass.setLayoutX(800);
        pass.setLayoutY(600);
        attack.setOnMouseClicked((MouseEvent e) -> {
            try {
                createLuigiAttack(primaryStage);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        useItem.setOnMouseClicked((MouseEvent e) -> {
            try {
                createLuigiUseItem(primaryStage);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        pass.setOnMouseClicked((MouseEvent e) -> {
            this.game.terminate();
            try {
                createPlayerInterface(primaryStage);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        luigiChooseLayout.getChildren().addAll(attack, useItem, pass);
    }

    private void createMarioUseItem(Stage primaryStage) throws FileNotFoundException {
        createbasicLayoutMain(marioChooseItemLayout, marioChooseItemScene);
        primaryStage.setScene(marioChooseItemScene);
        Text itemsText = new Text(300, 400, "Choose one of this Items:");
        itemsText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
        itemsText.setFill(Color.VIOLET);
        marioChooseItemLayout.getChildren().add(itemsText);
        for(int i=0; i<this.game.getItems().size();i++) {
            Item item = this.game.getItems().get(i);
            Button buttonItem = new Button(item.toString());
            buttonItem.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 12));
            buttonItem.setLayoutX(150+120*i);
            buttonItem.setLayoutY(500);
            buttonItem.setOnMouseClicked((MouseEvent e) -> {
                try {
                    createbasicLayoutMain(marioChoosePlayerLayout, marioChoosePlayerScene);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                Text playerText = new Text(260, 400, "Choose a player for it to take effect on:");
                playerText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
                playerText.setFill(Color.VIOLET);
                primaryStage.setScene(marioChoosePlayerScene);
                this.game.chooseItem(item.getName());
                Button buttonMario = new Button("Mario");
                buttonMario.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                buttonMario.setLayoutX(300);
                buttonMario.setLayoutY(450);
                buttonMario.setOnMouseClicked((MouseEvent ev) -> {
                    this.game.choosePlayer(this.game.getMarcos());
                    if(!this.game.Lost()&&!this.game.hasWon()){
                        try {
                            createPlayerInterface(primaryStage);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }else{
                        primaryStage.close();
                    }
                });
                Button buttonLuigi = new Button("Luigi");
                buttonLuigi.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                buttonLuigi.setLayoutX(600);
                buttonLuigi.setLayoutY(450);
                buttonLuigi.setOnMouseClicked((MouseEvent ev) -> {
                    this.game.choosePlayer(this.game.getLuigi());
                    if(!this.game.Lost()&&!this.game.hasWon()){
                        try {
                            createPlayerInterface(primaryStage);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }else{
                        primaryStage.close();
                    }
                });
                marioChoosePlayerLayout.getChildren().addAll(buttonMario, buttonLuigi,playerText);
            });
            marioChooseItemLayout.getChildren().add(buttonItem);
        }
    }

    private void createLuigiUseItem(Stage primaryStage) throws FileNotFoundException {
        createbasicLayoutMain(luigiChooseItemLayout, luigiChooseItemScene);
        primaryStage.setScene(luigiChooseItemScene);
        Text itemsText = new Text(300, 400, "Choose one of this Items:");
        itemsText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
        itemsText.setFill(Color.VIOLET);
        luigiChooseItemLayout.getChildren().add(itemsText);
        for(int i=0; i<this.game.getItems().size();i++) {
            Item item = this.game.getItems().get(i);
            Button buttonItem = new Button(item.toString());
            buttonItem.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 12));
            buttonItem.setLayoutX(150+120*i);
            buttonItem.setLayoutY(500);
            buttonItem.setOnMouseClicked((MouseEvent e) -> {
                try {
                    createbasicLayoutMain(luigiChoosePlayerLayout, luigiChoosePlayerScene);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                Text playerText = new Text(260, 400, "Choose a player for it to take effect on:");
                playerText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
                playerText.setFill(Color.VIOLET);
                primaryStage.setScene(luigiChoosePlayerScene);
                this.game.chooseItem(item.getName());
                Button buttonMario = new Button("Mario");
                buttonMario.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                buttonMario.setLayoutX(300);
                buttonMario.setLayoutY(450);
                buttonMario.setOnMouseClicked((MouseEvent ev) -> {
                    this.game.choosePlayer(this.game.getMarcos());
                    if(!this.game.Lost()&&!this.game.hasWon()){
                        try {
                            createPlayerInterface(primaryStage);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }else{
                        primaryStage.close();
                    }
                });
                Button buttonLuigi = new Button("Luigi");
                buttonLuigi.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                buttonLuigi.setLayoutX(600);
                buttonLuigi.setLayoutY(450);
                buttonLuigi.setOnMouseClicked((MouseEvent ev) -> {
                    this.game.choosePlayer(this.game.getLuigi());
                    if(!this.game.Lost()&&!this.game.hasWon()){
                        try {
                            createPlayerInterface(primaryStage);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }else{
                        primaryStage.close();
                    }
                });
                luigiChoosePlayerLayout.getChildren().addAll(buttonMario, buttonLuigi, playerText);
            });
            luigiChooseItemLayout.getChildren().add(buttonItem);
        }
    }

    public void createMarioAttack(Stage primaryStage) throws FileNotFoundException {
        createbasicLayoutMain(marioChooseVictimLayout, marioChooseVictimScene);
        primaryStage.setScene(marioChooseVictimScene);
        Text victimText = new Text(320, 400, "Choose an enemy to attack:");
        victimText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
        victimText.setFill(Color.VIOLET);
        marioChooseVictimLayout.getChildren().add(victimText);
        for(int i=0; i<this.game.getCharacters().size();i++) {
            Character enemy = this.game.getCharacters().get(i);
            if(enemy.getType()!="Luigi"&&enemy.getType()!="Marcos") {
                Button buttonEnemy = new Button(enemy.getType());
                buttonEnemy.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                buttonEnemy.setLayoutX(110+120*i);
                buttonEnemy.setLayoutY(460);
                buttonEnemy.setOnMouseClicked((MouseEvent e) -> {
                    try {
                        createbasicLayoutMain(marioChooseAttackLayout, marioChooseAttackScene);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    primaryStage.setScene(marioChooseAttackScene);
                    System.out.println(enemy + " was chosen");
                    this.game.chooseTargetMarcos((AttackableByMarcos) enemy);
                    Button buttonJump = new Button("Jump Attack");
                    buttonJump.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                    buttonJump.setLayoutX(300);
                    buttonJump.setLayoutY(450);
                    buttonJump.setOnMouseClicked((MouseEvent ev) -> {
                        this.game.marcosJumpAttack();
                        if(!this.game.Lost()&&!this.game.hasWon()){
                            try {
                                createPlayerInterface(primaryStage);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }else{
                            primaryStage.close();
                        }
                    });
                    Button buttonHammer = new Button("Hammer Attack");
                    buttonHammer.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                    buttonHammer.setLayoutX(600);
                    buttonHammer.setLayoutY(450);
                    buttonHammer.setOnMouseClicked((MouseEvent ev) -> {
                        System.out.println("Marcos Hammer Attacked");
                        this.game.marcosHammerAttack();
                        if(!this.game.Lost()&&!this.game.hasWon()){
                            try {
                                createPlayerInterface(primaryStage);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }else{
                            primaryStage.close();
                        }
                    });
                    marioChooseAttackLayout.getChildren().addAll(buttonJump, buttonHammer);
                });
                marioChooseVictimLayout.getChildren().add(buttonEnemy);
            }
        }
    }

    public void createLuigiAttack(Stage primaryStage) throws FileNotFoundException {
        createbasicLayoutMain(luigiChooseVictimLayout, luigiChooseVictimScene);
        primaryStage.setScene(luigiChooseVictimScene);
        Text victimText = new Text(320, 400, "Choose an enemy to attack:");
        victimText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
        victimText.setFill(Color.VIOLET);
        luigiChooseVictimLayout.getChildren().add(victimText);
        for(int i=0; i<this.game.getCharacters().size();i++) {
            Character enemy = this.game.getCharacters().get(i);
            if(enemy.getType()!="Luigi"&&enemy.getType()!="Marcos") {
                Button buttonEnemy = new Button(enemy.getType());
                buttonEnemy.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                buttonEnemy.setLayoutX(110+120*i);
                buttonEnemy.setLayoutY(460);
                buttonEnemy.setOnMouseClicked((MouseEvent e) -> {
                    try {
                        createbasicLayoutMain(luigiChooseAttackLayout, luigiChooseAttackScene);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    primaryStage.setScene(luigiChooseAttackScene);
                    System.out.println(enemy + " was chosen");
                    this.game.chooseTargetLuigi((AttackableByLuigi) enemy);
                    Button buttonJump = new Button("Jump Attack");
                    buttonJump.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                    buttonJump.setLayoutX(300);
                    buttonJump.setLayoutY(450);
                    buttonJump.setOnMouseClicked((MouseEvent ev) -> {
                        this.game.luigiJumpAttack();
                        if(!this.game.Lost()&&!this.game.hasWon()){
                            try {
                                createPlayerInterface(primaryStage);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }else{
                            primaryStage.close();
                        }
                    });
                    Button buttonHammer = new Button("Hammer Attack");
                    buttonHammer.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                    buttonHammer.setLayoutX(600);
                    buttonHammer.setLayoutY(450);
                    buttonHammer.setOnMouseClicked((MouseEvent ev) -> {
                        System.out.println("Luigi Hammer Attacked");
                        this.game.luigiHammerAttack();
                        if(!this.game.Lost()&&!this.game.hasWon()){
                            try {
                                createPlayerInterface(primaryStage);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }else{
                            primaryStage.close();
                        }
                    });
                    luigiChooseAttackLayout.getChildren().addAll(buttonJump, buttonHammer);
                });
                luigiChooseVictimLayout.getChildren().add(buttonEnemy);
            }
        }
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Mario and Luigi");
        this.game = new Game();
        this.game.addHoneySyrup(3);
        this.game.addRedMushroom(3);
        this.game.createBattle(3);
        primaryStage.setScene(marioChooseScene);
        createPlayerInterface(primaryStage);
        primaryStage.show();
    }

}

