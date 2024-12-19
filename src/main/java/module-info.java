module com.example.logik {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.logik to javafx.fxml;
    exports com.example.logik;
    exports com.example.logik.controller;
    opens com.example.logik.controller to javafx.fxml;
}