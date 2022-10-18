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

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class HintergrundMusik extends Thread {
    boolean running = true;
    boolean ON = true;
    boolean OFF = false;
    boolean OFF2 = true;
    boolean SoundON = true;

    public HintergrundMusik() {
    }

    public void run() {
        try {
            while (this.running) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream((new File("jazz.wav")).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                int i = 0;
                while (this.running) {
                    Thread.sleep(1000);
                    i++;
                    if (i > 24) {
                        break;
                    }
                }
                clip.close();

                if (!this.running) {

                    AudioInputStream audioStream2 = AudioSystem.getAudioInputStream((new File("beam.wav")).getAbsoluteFile());
                    Clip clip2 = AudioSystem.getClip();
                    clip2.open(audioStream2);
                    clip2.start();
                    Thread.sleep(1500);
                    clip2.close();

                }

            }
        } catch (UnsupportedAudioFileException var3) {
            var3.printStackTrace();
        } catch (IOException var4) {
            var4.printStackTrace();
        } catch (LineUnavailableException var5) {
            var5.printStackTrace();
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }

    }

    public static void playSound(String s, boolean SoundON) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
    }

    public void stopRunning() {
        this.running = false;
    }


}
