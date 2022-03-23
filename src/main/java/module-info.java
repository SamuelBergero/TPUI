module com.example.tp_ui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tp_ui to javafx.fxml;
    exports com.example.tp_ui;
}