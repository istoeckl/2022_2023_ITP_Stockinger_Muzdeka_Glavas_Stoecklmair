/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author : Glavas Lea, Stockinger Annika, Muzdeka Jovana und Iris Stöcklmair
 * @date : 27.10.2022
 * @details Diese Klasse ist das Model und Controller für die Hintergrundmusik
 */


package com.example.itp_projekt_snake.Model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class HintergrundMusik extends Thread {
    boolean running = true;
    boolean OFF = false;

    public void run() {
        try {
            while (this.running) {
                while (this.OFF) {
                    Thread.sleep(500);
                }
                AudioInputStream audioStream = AudioSystem.getAudioInputStream((new File("jazz.wav")).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                int i = 0;
                while (!this.OFF) {

                    Thread.sleep(1000);
                    i++;
                    if (i > 24) {
                        break;
                    }
                    if (!running) {
                        break;
                    }

                }
                clip.close();
                if (!this.running) {
                    Thread.sleep(800);
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

    public HintergrundMusik() {}

    public static void playSound(String s, boolean SoundON) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {}

    public void stopRunning() {
        this.running = false;
    }

    public void OFF() {
        this.OFF = true;
    }

    public void ON() {
        this.OFF = false;
    }

}


