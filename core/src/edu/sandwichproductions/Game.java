package edu.sandwichproductions;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import edu.sandwichproductions.view.GameDisplay;

public class Game extends ApplicationAdapter {
	GameDisplay gameDisplay;
	boolean count = true;

    @Override
	public void create () {
	 	gameDisplay = new GameDisplay();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0, 0.5F);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (!count) {
			dispose();
			Gdx.app.exit();
		} else {
			count = gameDisplay.update();
		}
	}

	@Override
	public void dispose() {

	}
}