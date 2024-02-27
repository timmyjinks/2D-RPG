package edu.sandwichproductions.controller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationHandler {
    private Texture texture;
    private int frameCount;
    private Animation<TextureRegion> animated;

    public AnimationHandler (String filePath, int frameCount) {
        texture = new Texture(filePath);
        TextureRegion[][] tmpFrames = TextureRegion.split(texture, texture.getWidth() / frameCount, texture.getHeight());
        TextureRegion[] animationFrames = new TextureRegion[frameCount];
        this.frameCount = frameCount;
        int frames = 0;
        for (int rows = 0; rows < 1; rows++) {
            for (int columns = 0; columns < frameCount; columns++) {
                animationFrames[frames++] = tmpFrames[rows][columns];
            }
        }
        animated = new Animation<>(0.1F, animationFrames);
    }

    public TextureRegion getKeyFrame(float elapsedTime, boolean loops) {
        return animated.getKeyFrame(elapsedTime, loops);
    }

    public int getCenter() {
        return (150 - (texture.getWidth() / frameCount)) / 2;
    }

    public int getWidth() {
        return texture.getWidth() / 4;
    }
}
