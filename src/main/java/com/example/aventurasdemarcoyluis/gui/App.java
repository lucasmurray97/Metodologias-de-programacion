package com.example.aventurasdemarcoyluis.gui;
import com.example.aventurasdemarcoyluis.model.Characters.Character;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByLuigi;
import com.example.aventurasdemarcoyluis.model.Characters.Players.AttackableByMarcos;
import com.example.aventurasdemarcoyluis.model.Game.Exceptions.InvalidCharacterActionException;
import com.example.aventurasdemarcoyluis.model.Game.Game;
import com.example.aventurasdemarcoyluis.model.Items.Item;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Scene;

/**
 * The GUI.
 */
public class App extends Application {
    private static final String RESOURCE_PATH = "src/main/resources/";
    private Game game;
    /**
     * The Width.
     */
    int width = 1000;
    /**
     * The Height.
     */
    int height = 700;
    /**
     * The Game count.
     */
    int gameCount = 0;
    /**
     * The Victory layout.
     */
    Group victoryLayout = new Group();
    /**
     * The Game over layout.
     */
    Group gameOverLayout = new Group();
    /**
     * The Mario choose layout.
     */
    Group marioChooseLayout = new Group();
    /**
     * The Mario choose item layout.
     */
    Group marioChooseItemLayout= new Group();
    /**
     * The Mario choose player layout.
     */
    Group marioChoosePlayerLayout= new Group();
    /**
     * The Mario choose victim layout.
     */
    Group marioChooseVictimLayout= new Group();
    /**
     * The Mario choose attack layout.
     */
    Group marioChooseAttackLayout= new Group();
    /**
     * The Luigi choose layout.
     */
    Group luigiChooseLayout =new Group();
    /**
     * The Luigi choose item layout.
     */
    Group luigiChooseItemLayout= new Group();
    /**
     * The Luigi choose player layout.
     */
    Group luigiChoosePlayerLayout= new Group();
    /**
     * The Luigi choose victim layout.
     */
    Group luigiChooseVictimLayout= new Group();
    /**
     * The Luigi choose attack layout.
     */
    Group luigiChooseAttackLayout= new Group();
    /**
     * The Victory scene.
     */
    Scene victoryScene = new Scene(victoryLayout);
    /**
     * The Game over scene.
     */
    Scene gameOverScene = new Scene(gameOverLayout);
    /**
     * The Mario choose scene.
     */
    Scene marioChooseScene = new Scene(marioChooseLayout);
    /**
     * The Mario choose item scene.
     */
    Scene marioChooseItemScene= new Scene(marioChooseItemLayout);
    /**
     * The Mario choose player scene.
     */
    Scene marioChoosePlayerScene= new Scene(marioChoosePlayerLayout);
    /**
     * The Mario choose victim scene.
     */
    Scene marioChooseVictimScene= new Scene(marioChooseVictimLayout);
    /**
     * The Mario choose attack scene.
     */
    Scene marioChooseAttackScene= new Scene(marioChooseAttackLayout);
    /**
     * The Luigi choose scene.
     */
    Scene luigiChooseScene = new Scene(luigiChooseLayout);
    /**
     * The Luigi choose item scene.
     */
    Scene luigiChooseItemScene= new Scene(luigiChooseItemLayout);
    /**
     * The Luigi choose player scene.
     */
    Scene luigiChoosePlayerScene= new Scene(luigiChoosePlayerLayout);
    /**
     * The Luigi choose victim scene.
     */
    Scene luigiChooseVictimScene= new Scene(luigiChooseVictimLayout);
    /**
     * The Luigi choose attack scene.
     */
    Scene luigiChooseAttackScene= new Scene(luigiChooseAttackLayout);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Creates basic layout for a given scene.
     *
     * @param layout the layout
     * @param scene  the scene
     * @throws FileNotFoundException the file not found exception
     */
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

    /**
     * Shows items. Adds them to a given layout.
     *
     * @param layout the layout
     * @param y      the y
     */
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

    /**
     * Create a player specific interface. Controls most of the GUI's flow.
     *
     * @param primaryStage the primary stage
     * @throws FileNotFoundException the file not found exception
     */
    public void createPlayerInterface(Stage primaryStage) throws FileNotFoundException {
        if(this.game.isInBattle()){
            Character currentCharacter = this.game.getCurrentPlayer();
            if(currentCharacter.getType()=="Marcos"){
                createMariochoose(primaryStage);
            }else if(currentCharacter.getType()=="Luigi"){
                createLuigichoose(primaryStage);
            }else{
                this.game.normalAttack();
                createPlayerInterface(primaryStage);
            }
        }else if(this.game.Lost()){
            ImageNodeBuilder backgroundBuilder = new ImageNodeBuilder(gameOverScene);
            ImageView background = backgroundBuilder.build(0, 0,width , height, RESOURCE_PATH, "background2.jpg");
            ImageView gameover = backgroundBuilder.build(300, 220,400 , 200, RESOURCE_PATH, "gameover.png");
            gameOverLayout.getChildren().addAll(background,gameover);
            primaryStage.setScene(gameOverScene);
        }else if (this.game.hasWon()){
            ImageNodeBuilder backgroundBuilder = new ImageNodeBuilder(victoryScene);
            ImageView background = backgroundBuilder.build(0, 0,width , height, RESOURCE_PATH, "background2.jpg");
            ImageView gameover = backgroundBuilder.build(300, 220,400 , 250, RESOURCE_PATH, "victory.jpg");
            gameOverLayout.getChildren().addAll(background,gameover);
            primaryStage.setScene(gameOverScene);

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

    /**
     * Create interface for marios turn.
     *
     * @param primaryStage the primary stage
     * @throws FileNotFoundException the file not found exception
     */
    public void createMariochoose(Stage primaryStage) throws FileNotFoundException {
        createbasicLayoutMain(marioChooseLayout, marioChooseScene);
        primaryStage.setScene(marioChooseScene);
        this.showItems(marioChooseLayout, 375);
        HBox buttons = new HBox(80);
        buttons.setPrefWidth(1000);
        Button attack = new Button("Attack");
        Button useItem = new Button("Use Item");
        Button pass = new Button("Pass");
        attack.setPrefWidth(150);
        useItem.setPrefWidth(150);
        pass.setPrefWidth(150);
        attack.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        useItem.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        pass.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        buttons.setLayoutY(600);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(pass,attack);

        attack.setOnMouseClicked((MouseEvent e) -> {
            try {
                createMarioAttack(primaryStage);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        useItem.setOnMouseClicked((MouseEvent e) -> {
            try {
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
        if(game.getItems().size()>0){
            buttons.getChildren().add(useItem);
        }
        marioChooseLayout.getChildren().add(buttons);
    }
    /**
     * Create interface for luigi's turn.
     *
     * @param primaryStage the primary stage
     * @throws FileNotFoundException the file not found exception
     */
    public void createLuigichoose(Stage primaryStage) throws FileNotFoundException {
        createbasicLayoutMain(luigiChooseLayout, luigiChooseScene);
        primaryStage.setScene(luigiChooseScene);
        this.showItems(luigiChooseLayout, 375);
        HBox buttons = new HBox(80);
        buttons.setLayoutY(600);
        buttons.setPrefWidth(1000);
        buttons.setAlignment(Pos.CENTER);
        Button attack = new Button("Attack");
        Button useItem = new Button("Use Item");
        Button pass = new Button("Pass");
        attack.setPrefWidth(150);
        useItem.setPrefWidth(150);
        pass.setPrefWidth(150);
        attack.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        useItem.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        pass.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
        attack.setLayoutX(150);
        attack.setLayoutY(600);
        useItem.setLayoutX(450);
        useItem.setLayoutY(600);
        pass.setLayoutX(800);
        pass.setLayoutY(600);
        buttons.getChildren().add(pass);
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
        int z = 0;
        for(int i=0; i<this.game.getCharacters().size();i++){
            Character character = this.game.getCharacters().get(i);
            if(character.getType()!="Boo" &&character.getType()!="Luigi"&&character.getType()!="Marcos"){
                z++;
            }
        }
        if(z>0){
            buttons.getChildren().add(attack);
        }
        if(this.game.getItems().size()>0){
            buttons.getChildren().add(useItem);
        }
        luigiChooseLayout.getChildren().add(buttons);
    }
    /**
     * Create interface for marios turn, when use item option is picked.
     *
     * @param primaryStage the primary stage
     * @throws FileNotFoundException the file not found exception
     */
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
                buttonMario.setPrefWidth(100);
                buttonMario.setOnMouseClicked((MouseEvent ev) -> {
                    this.game.choosePlayer(this.game.getMarcos());
                    if(!this.game.Lost()&&!this.game.hasWon()){
                        try {
                            createPlayerInterface(primaryStage);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }else{
                        try {
                            createPlayerInterface(primaryStage);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        ;
                    }
                });
                Button buttonLuigi = new Button("Luigi");
                buttonLuigi.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                buttonLuigi.setLayoutX(600);
                buttonLuigi.setLayoutY(450);
                buttonLuigi.setPrefWidth(100);
                buttonLuigi.setOnMouseClicked((MouseEvent ev) -> {
                    this.game.choosePlayer(this.game.getLuigi());
                    if(!this.game.Lost()&&!this.game.hasWon()){
                        try {
                            createPlayerInterface(primaryStage);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }else{
                        try {
                            createPlayerInterface(primaryStage);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                marioChoosePlayerLayout.getChildren().addAll(buttonMario, buttonLuigi,playerText);
            });
            marioChooseItemLayout.getChildren().add(buttonItem);
        }
    }
    /**
     * Create interface for marios turn, when use item option is picked.
     *
     * @param primaryStage the primary stage
     * @throws FileNotFoundException the file not found exception
     */
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
                buttonMario.setPrefWidth(100);
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
                        try {
                            createPlayerInterface(primaryStage);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        ;
                    }
                });
                Button buttonLuigi = new Button("Luigi");
                buttonLuigi.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                buttonLuigi.setLayoutX(600);
                buttonLuigi.setLayoutY(450);
                buttonLuigi.setPrefWidth(100);
                buttonLuigi.setOnMouseClicked((MouseEvent ev) -> {
                    this.game.choosePlayer(this.game.getLuigi());
                    if(!this.game.Lost()&&!this.game.hasWon()){
                        try {
                            createPlayerInterface(primaryStage);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }else{
                        try {
                            createPlayerInterface(primaryStage);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        ;
                    }
                });
                luigiChoosePlayerLayout.getChildren().addAll(buttonMario, buttonLuigi, playerText);
            });
            luigiChooseItemLayout.getChildren().add(buttonItem);
        }
    }

    /**
     * Create interface for marios turn, when attack option is picked.
     *
     * @param primaryStage the primary stage
     * @throws FileNotFoundException the file not found exception
     */
    public void createMarioAttack(Stage primaryStage) throws FileNotFoundException {
        createbasicLayoutMain(marioChooseVictimLayout, marioChooseVictimScene);
        primaryStage.setScene(marioChooseVictimScene);
        Text victimText = new Text(320, 400, "Choose an enemy to attack:");
        victimText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
        victimText.setFill(Color.VIOLET);
        marioChooseVictimLayout.getChildren().add(victimText);
        HBox enemies = new HBox(20);
        for(int i=0; i<this.game.getCharacters().size();i++) {
            Character enemy = this.game.getCharacters().get(i);
            if(enemy.getType()!="Luigi"&&enemy.getType()!="Marcos") {
                Button buttonEnemy = new Button(enemy.getType());
                buttonEnemy.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                buttonEnemy.setPrefWidth(120);
                buttonEnemy.setOnMouseClicked((MouseEvent e) -> {
                    try {
                        createbasicLayoutMain(marioChooseAttackLayout, marioChooseAttackScene);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    primaryStage.setScene(marioChooseAttackScene);
                    this.game.chooseTargetMarcos((AttackableByMarcos) enemy);
                    Button buttonJump = new Button("Jump Attack");
                    buttonJump.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                    buttonJump.setLayoutX(220);
                    buttonJump.setLayoutY(450);
                    buttonJump.setPrefWidth(200);
                    buttonJump.setOnMouseClicked((MouseEvent ev) -> {
                        this.game.marcosJumpAttack();
                        if(!this.game.Lost()&&!this.game.hasWon()){
                            try {
                                createPlayerInterface(primaryStage);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }else{
                            try {
                                createPlayerInterface(primaryStage);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                            ;
                        }
                    });
                    Button buttonHammer = new Button("Hammer Attack");
                    buttonHammer.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                    buttonHammer.setLayoutX(600);
                    buttonHammer.setLayoutY(450);
                    buttonHammer.setPrefWidth(200);
                    buttonHammer.setOnMouseClicked((MouseEvent ev) -> {
                        this.game.marcosHammerAttack();
                        if(!this.game.Lost()&&!this.game.hasWon()){
                            try {
                                createPlayerInterface(primaryStage);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }else{
                            try {
                                createPlayerInterface(primaryStage);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                            ;
                        }
                    });
                    marioChooseAttackLayout.getChildren().addAll(buttonJump, buttonHammer);
                });
                enemies.getChildren().add(buttonEnemy);
            }
        }
        enemies.setLayoutY(460);
        enemies.setPrefWidth(1000);
        enemies.setAlignment(Pos.CENTER);
        marioChooseVictimLayout.getChildren().add(enemies);
    }

    /**
     * Create interface for luigi's turn, when attack option is chosen.
     *
     * @param primaryStage the primary stage
     * @throws FileNotFoundException the file not found exception
     */
    public void createLuigiAttack(Stage primaryStage) throws FileNotFoundException {
        createbasicLayoutMain(luigiChooseVictimLayout, luigiChooseVictimScene);
        primaryStage.setScene(luigiChooseVictimScene);
        Text victimText = new Text(320, 400, "Choose an enemy to attack:");
        victimText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
        victimText.setFill(Color.VIOLET);
        luigiChooseVictimLayout.getChildren().add(victimText);
        HBox enemies = new HBox(20);
        for(int i=0; i<this.game.getCharacters().size();i++) {
            Character enemy = this.game.getCharacters().get(i);
            if(enemy.getType()!="Luigi"&&enemy.getType()!="Marcos"&&enemy.getType()!="Boo") {
                Button buttonEnemy = new Button(enemy.getType());
                buttonEnemy.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                buttonEnemy.setPrefWidth(120);
                buttonEnemy.setOnMouseClicked((MouseEvent e) -> {
                    try {
                        createbasicLayoutMain(luigiChooseAttackLayout, luigiChooseAttackScene);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    primaryStage.setScene(luigiChooseAttackScene);
                    this.game.chooseTargetLuigi((AttackableByLuigi) enemy);
                    Button buttonJump = new Button("Jump Attack");
                    buttonJump.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                    buttonJump.setLayoutX(220);
                    buttonJump.setLayoutY(450);
                    buttonJump.setPrefWidth(200);
                    buttonJump.setOnMouseClicked((MouseEvent ev) -> {
                        this.game.luigiJumpAttack();
                        if(!this.game.Lost()&&!this.game.hasWon()){
                            try {
                                createPlayerInterface(primaryStage);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }else{
                            try {
                                createPlayerInterface(primaryStage);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    Button buttonHammer = new Button("Hammer Attack");
                    buttonHammer.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
                    buttonHammer.setLayoutX(600);
                    buttonHammer.setLayoutY(450);
                    buttonHammer.setPrefWidth(200);
                    buttonHammer.setOnMouseClicked((MouseEvent ev) -> {
                        this.game.luigiHammerAttack();
                        if(!this.game.Lost()&&!this.game.hasWon()){
                            try {
                                createPlayerInterface(primaryStage);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }else{
                            try {
                                createPlayerInterface(primaryStage);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                            ;
                        }
                    });
                    luigiChooseAttackLayout.getChildren().addAll(buttonJump, buttonHammer);
                });
                enemies.getChildren().add(buttonEnemy);
            }
        }
        enemies.setLayoutY(460);
        enemies.setPrefWidth(1000);
        enemies.setAlignment(Pos.CENTER);
        luigiChooseVictimLayout.getChildren().add(enemies);
    }
    /**
     * Starts GUI and gameflow.
     *
     * @param primaryStage the primary stage
     */
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

