package com.example.itp_projekt_snake.Controller;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SpielfeldController {
    private static final int WIDTH = 800;
    private static final int HEIGHT = WIDTH;
    private static final int ROWS = 20;
    private static final int COLUMNS = ROWS;
    private static final int SQUARE_SIZE = WIDTH / ROWS;

    private String black = "#000000";
    private String hell = "90cbf9";
    private String dunkel = "bbdffb";
    private int score = 0;

    public void drawBackground(GraphicsContext gc) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
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

    public void drawStartSnake(GraphicsContext gc) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                //Startpunkt Schlange
                if (i == 4 && j == 8) {
                    gc.setFill(Color.web(black));
                }
            }
        }
        gc.fillRect(4 * SQUARE_SIZE, 8 * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
    }



    public void drawScore(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial", 35));
        gc.fillText("Score: " + score, 10, 30);
    }

}
