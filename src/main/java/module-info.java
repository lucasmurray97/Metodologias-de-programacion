module com.example.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aventurasdemarcoyluis to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.abstractclasses;
    opens com.example.aventurasdemarcoyluis.abstractclasses to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.interfaces;
    opens com.example.aventurasdemarcoyluis.interfaces to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.classes;
    opens com.example.aventurasdemarcoyluis.classes to javafx.fxml;
}