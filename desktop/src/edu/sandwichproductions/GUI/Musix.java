package edu.sandwichproductions.GUI;
import com.badlogic.gdx.Audio;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Musix {
    public void playAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("assets/THeSONGwavv.wav");
        if (!file.exists()) {
            System.err.println("Audio file not found.");
            return;
        }

        while (true) {
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
            clip.drain();
            clip.close();
        }
    }
}
