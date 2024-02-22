package edu.sandwichproductions;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import edu.sandwichproductions.controller.GameController;

public class Game extends ApplicationAdapter {
	private GameController controller;
	private SpriteBatch batch;
	private Sprite room;
	private Sprite enemyRoom;
	private Sprite character;
	private Sprite enemy;
	private int tileHeight;
	private int tileWidth;
	private int characterXPosition;
	private int characterYPosition;
	private int entityDimension;

    @Override
	public void create () {
		batch = new SpriteBatch();
		room = new Sprite(new Texture("room.png"), 180, 180);
		enemyRoom = new Sprite(new Texture("enemyroom.png"), 180, 180);
		character = new Sprite(new Texture("badlogic.jpg"), 50, 50);
		enemy = new Sprite(new Texture("skeleton.png"), 50 , 50);
		tileHeight = (int)room.getHeight();
		tileWidth = (int)room.getWidth();
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
        entityDimension = (int) ((tileWidth - character.getWidth()) / 2);
		characterXPosition = characterXPosition * (tileWidth + 1) + entityDimension;
		characterYPosition = characterYPosition * (tileHeight + 1) + entityDimension;
		controller.getMyMovement().move(controller.getPlayer());
	}

	public void drawMap() {
		int currentPlayerPosition = controller.getWorld().getPlayerWorldPosition();
		batch.begin();
		for (int row = 0; row < 7; row++) {
			for (int column = 0; column < 7; column++) {
				if (controller.getWorld().getRooms()[currentPlayerPosition / 5][currentPlayerPosition % 5].isEnemyRoom()) {
					batch.draw(this.enemyRoom, row * (tileWidth + 1), column * (tileHeight + 1));
					if (controller.getWorld().getRooms()[currentPlayerPosition / 5][currentPlayerPosition % 5].getRoomPositions()[row][column] == 50) {
						batch.draw(enemy, row * (tileWidth + 1) + entityDimension, column * (tileHeight + 1) + entityDimension);
					}
				} else {
					batch.draw(this.room, row * (tileWidth + 1), column * (tileHeight + 1));
				}
			}
		}

		batch.draw(character, characterXPosition, characterYPosition);
		batch.end();
	}
}