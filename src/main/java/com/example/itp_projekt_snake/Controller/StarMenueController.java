/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author : Glavas Lea, Stockinger Annika, Muzdeka Jovana und Iris Stöcklmair
 * @date : 27.10.2022
 * @details Diese Klasse ist der Controller für das Startmenue
 */

package com.example.itp_projekt_snake.Controller;

import com.example.itp_projekt_snake.View.SpielfeldView;
import javafx.stage.Stage;

public class StarMenueController {

    /**
     * StarMenueController()
     * Konstruktor
     *
     * @return 	none
     */
    public StarMenueController() {
    }

    /**
     * spielfeldAnzeigen()
     * Anzeige des Spielfelds
     *
     * @return 	none
     */
    public void spielfeldAnzeigen() throws Exception {
        SpielfeldView view = new SpielfeldView();
        Stage pro = new Stage();
        view.start(pro);
    }


}
