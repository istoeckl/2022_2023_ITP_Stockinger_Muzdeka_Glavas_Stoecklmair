package com.example.itp_projekt_snake.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.Point;
import java.util.ArrayList;

import static com.example.itp_projekt_snake.Model.Spielfeld.ROWS;
import static com.example.itp_projekt_snake.Model.Spielfeld.SQUARE_SIZE;

public class Snake {
    public java.util.List<Point> snakeBody = new ArrayList();
    public Point snakeHead;

    public void drawStartSnake(GraphicsContext gc) {
        for (int i = 0; i < 3; i++) {
            snakeBody.add(new Point(5, ROWS / 2));
        }
        snakeHead = snakeBody.get(0);

        gc.setFill(Color.web("#000000"));
        gc.fillRoundRect(snakeHead.getX() * SQUARE_SIZE, snakeHead.getY() * SQUARE_SIZE, SQUARE_SIZE - 1, SQUARE_SIZE - 1, 35, 35);

        for (int i = 1; i < snakeBody.size(); i++) {
            gc.fillRoundRect(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE, SQUARE_SIZE - 1,
                    SQUARE_SIZE - 1, 20, 20);
        }
    }

    public void moveSnake(GraphicsContext gc) {
        for (int i = snakeBody.size() - 1; i >= 1; i--) {
            snakeBody.get(i).x = snakeBody.get(i - 1).x;
            snakeBody.get(i).y = snakeBody.get(i - 1).y;
        }
    }


}
