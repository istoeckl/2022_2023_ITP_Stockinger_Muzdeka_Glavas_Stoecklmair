package com.example.itp_projekt_snake.Controller;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.Random;

import static com.example.itp_projekt_snake.Model.Spielfeld.SQUARE_SIZE;


public class SpielfeldController {
    private String pink = "ffc0cb";
    private String hell = "90cbf9";
    private String dunkel = "bbdffb";


    //lea glavas
    public void drawFood(GraphicsContext gc) {

        Random random = new Random();
        int value1 = 1 + random.nextInt(10);
        int value2 = 1 + random.nextInt(10);
        System.out.println(value1);

        gc.setFill(Color.web(pink));


        gc.fillRect(value1 * SQUARE_SIZE, value2 * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
    }

}
