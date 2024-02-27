package edu.sandwichproductions.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import edu.sandwichproductions.controller.AnimationHandler;
import edu.sandwichproductions.controller.GameController;
import edu.sandwichproductions.model.entity.Enemy;
import edu.sandwichproductions.model.entity.Player;

public class GameEntitySprite {
    private AnimationHandler character;
    private AnimationHandler enemy;
    private int characterRoomRow;
    private int characterRoomColumn;
    private int characterXPosition;
    private int characterYPosition;
    private int entityDimension;

    public GameEntitySprite() {
        character = new AnimationHandler("Knight_Idle.png", 6);
        enemy = new AnimationHandler("Skeleton_Idle.png", 4);
    }

    public AnimationHandler getCharacter() {
        return character;
    }

    public AnimationHandler getEnemy() {
        return enemy;
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
        characterXPosition = characterRoomRow * (floorWidth + 1) + entityDimension + character.getCenter();
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
        this.entityDimension = (floorWidth - character.getWidth()) / 2;
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
