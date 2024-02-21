package edu.sandwichproductions;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.sandwichproductions.controller.GameController;
import edu.sandwichproductions.controller.MovementController;
import edu.sandwichproductions.model.map.Map;

public class Game extends ApplicationAdapter {
	private GameController controller;
	private SpriteBatch batch;
	private Sprite tile;
	private Sprite character;
	private int tileHeight;
	private int tileWidth;
	private int characterXPosition;
	private int characterYPosition;

    @Override
	public void create () {
		batch = new SpriteBatch();
		tile = new Sprite(new Texture("room.png"), 180, 180);
		tile.setCenter((float) tileWidth / 2, (float) tileHeight / 2);
		character = new Sprite(new Texture("badlogic.jpg"), 50, 50);
		tileHeight = (int)tile.getHeight();
		tileWidth = (int)tile.getWidth();
		controller = new GameController();
		controller.run();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0, 0.5F);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		updateCharacterPosition();
		drawMap();

		characterXPosition = controller.getPlayer().getPositionInRoom() / 7;
		characterYPosition = controller.getPlayer().getPositionInRoom() % 7;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public void updateCharacterPosition() {
        int characterDimension = (int) ((tileWidth - character.getWidth()) / 2);
		characterXPosition = characterXPosition * (tileHeight + 1) + characterDimension;
		characterYPosition = characterYPosition * (tileWidth + 1) + characterDimension;
		controller.getMyMovement().move(controller.getPlayer());
	}

	public void drawMap() {
		batch.begin();
		for (int row = 0; row < 7; row++) {
			for (int column = 0; column < 7; column++) {
				batch.draw(tile, row * (tileHeight + 1),column * (tileWidth + 1));
			}
		}
		batch.draw(character, characterXPosition, characterYPosition);
		batch.end();
	}
}