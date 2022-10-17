/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author : Glavas Lea, Stockinger Annika, Muzdeka Jovana und Iris Stöcklmair
 * @date : 27.10.2022
 * @details In dieser Klasse werden die SteamOperationen angelegt
 */

package com.example.itp_projekt_snake.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static com.example.itp_projekt_snake.View.SpielfeldView.*;


public class Spielfeld {

    public int punkte = 0;

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    public Spielfeld() {}

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    public void hintergrundMitFarbe(GraphicsContext gc) {
        for (int i = 0; i < reihen; i++) {
            for (int j = 0; j < spalten; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web("bbdffb"));
                } else {
                    gc.setFill(Color.web("90cbf9"));
                }
                gc.fillRect(i * quadratGroesse, j * quadratGroesse, quadratGroesse, quadratGroesse);
            }
        }
    }

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    public void punkteAnzeigen(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Digital-7", 35));
        gc.fillText("Punkte: " + punkte, 10, 35);
    }


}
