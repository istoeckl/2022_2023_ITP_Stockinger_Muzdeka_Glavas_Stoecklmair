package com.example.itp_projekt_snake.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static com.example.itp_projekt_snake.View.SpielfeldView.gc;

public class Spielfeld {
    public static final int WIDTH = 800;
    public static final int HEIGHT = WIDTH;
    public static final int ROWS = 20;
    public static final int COLUMNS = ROWS;
    public static final int SQUARE_SIZE = WIDTH / ROWS;

    public static final int RIGHT = 0;
    public static final int LEFT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    public int currentDirection;
    private int score = 0;

    public void backgroundWithColour(GraphicsContext gc) {

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web("bbdffb"));
                } else {
                    gc.setFill(Color.web("90cbf9"));
                }
                gc.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }

    public void handle(KeyEvent event) {
        KeyCode code = event.getCode();
        if (code == KeyCode.RIGHT || code == KeyCode.D) {
            if (currentDirection != LEFT) {
                currentDirection = RIGHT;
            }
        } else if (code == KeyCode.LEFT || code == KeyCode.A) {
            if (currentDirection != RIGHT) {
                currentDirection = LEFT;
            }
        } else if (code == KeyCode.UP || code == KeyCode.W) {
            if (currentDirection != DOWN) {
                currentDirection = UP;
            }
        } else if (code == KeyCode.DOWN || code == KeyCode.S) {
            if (currentDirection != UP) {
                currentDirection = DOWN;
            }
        }
    }


    private void showScore() {
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial", 35));
        gc.fillText("Score: " + score, 10, 30);
    }


}








