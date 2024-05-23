module org.example.school_manager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.school_manager to javafx.fxml;
    exports org.example.school_manager;

    opens org.example.controllers to javafx.fxml;
    exports org.example.controllers;
}