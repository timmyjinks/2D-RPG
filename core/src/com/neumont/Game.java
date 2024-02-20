package com.neumont;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.neumont.model.map.Map;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Map map;
	Sprite tile;
	Sprite[][] spriteMap;
	Sprite character;
	Sprite weapon;
	int tileHeight;
	int tileWidth;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		tile = new Sprite(new Texture("room.png"), 250, 250);
		character = new Sprite(new Texture("badlogic.jpg"), 50, 50);
		weapon = new Sprite(new Texture("badlogic.jpg"), 20, 20);
		map = new Map();
		spriteMap = new Sprite[5][5];
		tileHeight = (int)tile.getHeight();
		tileWidth = (int)tile.getWidth();
	}

	@Override
	public void render () {
		batch.begin();
		for (int row = 0; row < map.getRooms().length; row++) {
			for (int column = 0; column < map.getRooms().length; column++) {
				batch.draw(tile, row * (tileHeight + 1),column * (tileWidth + 1));
			}
		}
		batch.end();
	}
	
	@Override
	public void dispose () {

	}
}