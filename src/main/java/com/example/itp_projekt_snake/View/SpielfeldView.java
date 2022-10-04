package com.example.itp_projekt_snake.View;

import com.example.itp_projekt_snake.Controller.SpielfeldController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class SpielfeldView extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = WIDTH;
    private static final int ROWS = 20;
    private static final int COLUMNS = ROWS;
    private static final int SQUARE_SIZE = WIDTH / ROWS;

    private GraphicsContext gc;
    private int score = 0;

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
        SpielfeldController control=new SpielfeldController();
        control.drawBackground(gc);
        control.drawScore(gc);
        control.drawStartSnake(gc);

    }



    }

