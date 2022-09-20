module com.example.itp_projekt_snake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.itp_projekt_snake to javafx.fxml;
    exports com.example.itp_projekt_snake;
}