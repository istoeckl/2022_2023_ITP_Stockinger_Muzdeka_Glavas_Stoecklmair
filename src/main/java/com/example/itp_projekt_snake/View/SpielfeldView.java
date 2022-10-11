package com.example.itp_projekt_snake.View;

import com.example.itp_projekt_snake.Controller.HelloController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import static com.example.itp_projekt_snake.Model.Spielfeld.HEIGHT;
import static com.example.itp_projekt_snake.Model.Spielfeld.WIDTH;

 public class SpielfeldView extends Application {

    public static GraphicsContext gc;
    private int currentDirection;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Snake-Spiel");
        Group root = new Group();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        gc = canvas.getGraphicsContext2D();
        HelloController cont = new HelloController();
        cont.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
