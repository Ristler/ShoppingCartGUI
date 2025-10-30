module org.example.otp2gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.otp2gui to javafx.fxml;
    exports org.example.otp2gui;
}