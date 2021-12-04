module com.example.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.jetbrains.annotations;
    exports com.example.aventurasdemarcoyluis.gui;
    exports com.example.aventurasdemarcoyluis.model.Characters;
    opens com.example.aventurasdemarcoyluis.model.Characters to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.Items;
    opens com.example.aventurasdemarcoyluis.model.Items to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.Characters.Enemies;
    opens com.example.aventurasdemarcoyluis.model.Characters.Enemies to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.Characters.Players;
    opens com.example.aventurasdemarcoyluis.model.Characters.Players to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.Characters.States;
    opens com.example.aventurasdemarcoyluis.model.Characters.States to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.Game;
    opens com.example.aventurasdemarcoyluis.model.Game to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.Battle;
    opens com.example.aventurasdemarcoyluis.model.Battle to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.Battle.BattleStates;
    opens com.example.aventurasdemarcoyluis.model.Battle.BattleStates to javafx.fxml;
    exports com.example.aventurasdemarcoyluis;
    opens com.example.aventurasdemarcoyluis to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.Game.GameStates;
    opens com.example.aventurasdemarcoyluis.model.Game.GameStates to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model;
    opens com.example.aventurasdemarcoyluis.model to javafx.fxml;
}
