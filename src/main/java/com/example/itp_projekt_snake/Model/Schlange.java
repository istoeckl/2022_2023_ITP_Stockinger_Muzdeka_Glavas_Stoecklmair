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

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.itp_projekt_snake.View.SpielfeldView.quadratGroesse;
import static com.example.itp_projekt_snake.View.SpielfeldView.reihen;


public class Schlange {
    public List<Point> schlangenKoerper = new ArrayList();
    public Point schlangenKopf;

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    public Schlange() {}

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    public void anfangsSchlangeZeichnen(GraphicsContext gc){
        for (int i = 0; i < 3; i++) {

            schlangenKoerper.add(new Point(5, reihen / 2));
        }
        schlangenKopf = schlangenKoerper.get(0);
    }

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    public void schlangeZeichnen(GraphicsContext gc) {
        schlangenKopf = schlangenKoerper.get(0);
        gc.setFill(Color.web("000000"));
        gc.fillRoundRect(schlangenKopf.getX() * quadratGroesse, schlangenKopf.getY() * quadratGroesse, quadratGroesse - 1, quadratGroesse - 1, 35, 35);

        for (int i = 1; i < schlangenKoerper.size(); i++) {
            gc.fillRoundRect(schlangenKoerper.get(i).getX() * quadratGroesse, schlangenKoerper.get(i).getY() * quadratGroesse, quadratGroesse - 1,
                    quadratGroesse - 1, 20, 20);
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
    // Shclange wird nicht immer größer sondern bleibt solange sioe nichts isst
    public void beibehaltenSchlangenGroesse(){
        for (int i = schlangenKoerper.size() - 1; i >= 1; i--) {
            schlangenKoerper.get(i).x = schlangenKoerper.get(i - 1).x;
            schlangenKoerper.get(i).y = schlangenKoerper.get(i - 1).y;
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
    public void nachRechts() {
        schlangenKopf.x++;
    }

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    public void nachLinks() {
        schlangenKopf.x--;
    }

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    public void nachOben() {
        schlangenKopf.y--;
    }

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    public void nachUnten() {
        schlangenKopf.y++;
    }

}
