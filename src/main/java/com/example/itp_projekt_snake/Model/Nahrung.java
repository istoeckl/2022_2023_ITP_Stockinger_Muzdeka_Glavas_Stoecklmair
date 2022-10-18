/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author : Glavas Lea, Stockinger Annika, Muzdeka Jovana und Iris Stöcklmair
 * @date : 27.10.2022
 * @details  Diese Klasse ist das Model für die Nahrung
 */

package com.example.itp_projekt_snake.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.Random;

import static com.example.itp_projekt_snake.View.SpielfeldView.*;


public class Nahrung {
    // private Image foodImage;
    public int essen_x;
    public int essen_Y;
    public String[] farben = {"#FF0000", "#FFFF00", "#696969", "#006400"};

    Schlange schlange = new Schlange();
    Spielfeld spiel = new Spielfeld();
    Random r = new Random();
    int zufallsFarbeZahl =0;

    /**
     * generateFood()
     * Essen Koordinaten und Farbe wird generiert
     *
     * @return 	none
     */
    public void generateFood() {
        start:
        while (true) {
            essen_x = (int) (Math.random() * reihen);
            essen_Y = (int) (Math.random() * spalten);

            for (Point snake : schlange.schlangenKoerper) {
                if (snake.getX() == essen_x && snake.getY() == essen_Y) {
                    continue start;
                }
            }
            break;
        }
            zufallsFarbeZahl = r.nextInt(3);
    }

    /**
     * drawFood(GraphicsContext gc)
     * Essen wird dargestellt
     * @param gc   Hintergrund
     *
     * @return 	none
     */
    public void drawFood(GraphicsContext gc) {
        gc.setFill(Color.web(farben[zufallsFarbeZahl]));
        gc.fillRect(essen_x * quadratGroesse, essen_Y * quadratGroesse, quadratGroesse, quadratGroesse);
    }


}
