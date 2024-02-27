package edu.sandwichproductions.controller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationHandler {
    private Texture texture;
    private int rows, columns, frameCount;
    private String filePath;
    private float frameDuration;
    private Animation<TextureRegion> animated;

    public AnimationHandler (String filePath, int columns, int frameCount) {
        texture = new Texture(filePath);
        TextureRegion[][] tmpFrames = TextureRegion.split(texture, texture.getWidth() / frameCount, texture.getHeight());
        TextureRegion[] animationFrames = new TextureRegion[4];
        int frames = 0;
        for (int rowsI = 0; rowsI < 1; rowsI++) {
            for (int columnsI = 0; columnsI < columns; columnsI++) {
                animationFrames[frames++] = tmpFrames[rowsI][columnsI];
            }
        }
        animated = new Animation<>(0.1F, animationFrames);
    }

    public TextureRegion getKeyFrame(float elapsedTime, boolean loops) {
        return animated.getKeyFrame(elapsedTime, loops);
    }

    public int getCenter() {
        return (150 - (texture.getWidth() / 4)) / 2;
    }
}
