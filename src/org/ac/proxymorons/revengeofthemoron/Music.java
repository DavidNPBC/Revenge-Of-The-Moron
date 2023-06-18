package org.ac.proxymorons.revengeofthemoron;

    /*public static void playSoundEffect(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }*/

//Version for IntelliJ
//To do the Jar, comment this out. Also change resource handler to blank.

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Music {
        private Clip clip;
        private URL soundURL;

        public Music(String path) {
            initClip(path);
        }
        public void play(boolean fromStart) {
            if (fromStart) {
                clip.setFramePosition(0);
            }
            clip.start();
        }

        public void stop() {
            clip.stop();
        }
        private void initClip(String path) {
            soundURL = Music.class.getResource(path);
            AudioInputStream inputStream = null;
            try {
                if (soundURL == null) {
                    path = path.substring(0);
                    File file = new File(path);
                    soundURL = file.toURI().toURL();
                }
                inputStream = AudioSystem.getAudioInputStream(soundURL);
                clip = AudioSystem.getClip();
                clip.open(inputStream);
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Version for Jar

    /*private Clip clip;

    public Music(String path) {
        initClip("/" + path);
    }

    public void play(boolean fromStart) {
        if (fromStart) {
            clip.setFramePosition(0);
        }
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

    private void initClip(String path) {
        try {
            InputStream is = Music.class.getResourceAsStream(path);
            if (is == null) {
                throw new RuntimeException("Resource not found: " + path);
            }
            InputStream bufferedIn = new BufferedInputStream(is);
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(bufferedIn);
            clip = AudioSystem.getClip();
            clip.open(inputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
*/


