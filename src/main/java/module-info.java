module com.example.itp_projekt_snake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.itp_projekt_snake to javafx.fxml;
    exports com.example.itp_projekt_snake;
    exports com.example.itp_projekt_snake.Controller;
    opens com.example.itp_projekt_snake.Controller to javafx.fxml;
    exports com.example.itp_projekt_snake.View;
    opens com.example.itp_projekt_snake.View to javafx.fxml;
}