package edu.sandwichproductions.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import edu.sandwichproductions.controller.GameController;
import edu.sandwichproductions.model.entity.Enemy;
import edu.sandwichproductions.model.entity.Player;

public class GameEntitySprite {
    private Sprite character;
    private Sprite enemy;
    private int characterRoomRow;
    private int characterRoomColumn;
    private int characterXPosition;
    private int characterYPosition;
    private int entityDimension;
    private Enemy currentEnemy;

    public GameEntitySprite() {
        character = new Sprite(new Texture("shlagg.jpg"), 150, 150);
        enemy = new Sprite(new Texture("skeleton.png"));
    }

    public Sprite getCharacter() {
        return character;
    }

    public void setCharacter(Sprite character) {
        this.character = character;
    }

    public Sprite getEnemy() {
        return enemy;
    }

    public void setEnemy(Sprite enemy) {
        this.enemy = enemy;
    }

    public int getCharacterRoomRow() {
        return characterRoomRow;
    }

    public void setCharacterRoomRow(int playerPositionInRoom) {
        characterRoomRow = playerPositionInRoom / 7;
    }

    public void setCharacterRoomColumn(int playerPositionInRoom) {
        characterRoomColumn = playerPositionInRoom % 7;
    }

    public int getCharacterXPosition() {
        return characterXPosition;
    }

    public void setCharacterXPosition(int floorWidth) {
        characterXPosition = characterRoomRow * (floorWidth + 1) + entityDimension;
    }

    public int getCharacterYPosition() {
        return characterYPosition;
    }

    public void setCharacterYPosition(int floorHeight) {
        characterYPosition = characterRoomColumn * (floorHeight + 1) + entityDimension;
    }

    public int getEntityDimension() {
        return entityDimension;
    }

    public void setEntityDimensionToCenter(int floorWidth) {
        this.entityDimension = (int) ((floorWidth - character.getWidth()) / 2);
    }

    public void setCharacterRoomPositions(Player player) {
        setCharacterRoomRow(player.getPositionInRoom());
        setCharacterRoomColumn(player.getPositionInRoom());
    }

    public void updateCharacterPosition(int floorWidth, int floorHeight) {
        setEntityDimensionToCenter(floorWidth);
        setCharacterXPosition(floorWidth);
        setCharacterYPosition(floorHeight);
    }
}
