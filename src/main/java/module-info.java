module com.example.oopproject2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.oopproject2 to javafx.fxml;
    exports com.example.oopproject2;
}