module com.example.tp_ui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tp_ui to javafx.fxml;
    exports com.example.tp_ui;
    exports com.example.tp_ui.Controller;
    opens com.example.tp_ui.Controller to javafx.fxml;
    exports com.example.tp_ui.Model;
    opens com.example.tp_ui.Model to javafx.fxml;
}