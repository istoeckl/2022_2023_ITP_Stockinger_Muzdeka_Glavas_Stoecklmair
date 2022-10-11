package com.example.itp_projekt_snake.Controller;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.Random;


public class SpielfeldController {
    private static final int WIDTH = 800;
    private static final int HEIGHT = WIDTH;

    private static final int ROWS = 20;
    private static final int COLUMN = 20;
    private static final int SQUARE_SIZE = WIDTH / ROWS;

    private String pink = "ffc0cb";
    private String hell = "90cbf9";
    private String dunkel = "bbdffb";
    private int score = 0;

    public void drawBackground(GraphicsContext gc) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMN; j++) {
                String[][] feld = new String[i][j];
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web(dunkel));
                } else {
                    gc.setFill(Color.web(hell));
                }
                gc.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }


    //lea glavas
    public void drawFood(GraphicsContext gc) {

        Random random = new Random();
        int value1 = 1 + random.nextInt(10);
        int value2 = 1 + random.nextInt(10);
        System.out.println(value1);

        gc.setFill(Color.web(pink));


        gc.fillRect(value1 * SQUARE_SIZE, value2 * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
    }




    public void drawScore(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial", 35));
        gc.fillText("Score: " + score, 10, 30);
    }

}
