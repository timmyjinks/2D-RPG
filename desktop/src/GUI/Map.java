package GUI;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import edu.sandwichproductions.Game;

public class Map {
    public Map() {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setWindowedMode(2200,1300);
        config.setResizable(false);
        config.setTitle("CSC150_FinalGame");
        new Lwjgl3Application(new Game(), config);
    }
}
