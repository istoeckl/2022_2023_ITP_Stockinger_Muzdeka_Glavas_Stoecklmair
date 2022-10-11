package com.example.itp_projekt_snake.Controller;

import com.example.itp_projekt_snake.Model.Food;
import com.example.itp_projekt_snake.Model.Snake;
import com.example.itp_projekt_snake.Model.Spielfeld;

import static com.example.itp_projekt_snake.View.SpielfeldView.gc;


public class HelloController {
    Food food =new Food();
    Spielfeld spiel =new Spielfeld();
    Snake snake = new Snake();

    public void start() {
        spiel.backgroundWithColour(gc);
        Snake snake = new Snake();
        snake.drawStartSnake(gc);
        snake.moveSnake(gc);

    }


}