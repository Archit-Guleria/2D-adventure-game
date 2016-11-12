/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audio;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author archit
 */

//Sfx.soundSetting = Toggle.OFF;

public enum Sfx {
    JUMP("sfx/SFX_Jump_35.wav"),    
    COIN("sfx/Collect_Point_02.wav"),
    PICKUP("sfx/Pickup_01.wav"),
    DEATH("sfx/death.wav"),
    EXPLODE("sfx/Explosion_00.wav"),
    WIN("sfx/round_end.wav"),
    LOSE("sfx/Jingle_Lose_00.wav");
    

    public static enum Toggle {
        ON, OFF
    }
    public static Toggle soundSetting = Toggle.ON;

    private Clip clip;

    Sfx(String soundFileName) {
        try {
            // Use URL (instead of File) to read from disk and JAR.
            URL url = this.getClass().getClassLoader().getResource(soundFileName);
            // Set up an audio input stream piped from the sound file.
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            // Get a clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        }
    }

    // Play or Re-play the sound effect from the beginning, by rewinding.
    public void play() {
        if (soundSetting != Toggle.OFF) {
            if (clip.isRunning()) {
                clip.stop();   // Stop the player if it is still running
            }
            clip.setFramePosition(0); // rewind to the beginning
            clip.start();     // Start playing
        }
    }
    
    

    // Optional static method to pre-load all the sound files.
    static void init() {
        values(); // calls the constructor for all the elements
    }

}
