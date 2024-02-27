package GUI;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import edu.sandwichproductions.Game;

import javax.swing.*;

public class MapGUI {

    public MapGUI() {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setWindowedMode(2560, 1400);
        config.setResizable(true);
        config.setTitle("CSC150_FinalGame");
        new Lwjgl3Application(new Game(), config);
    }
}
