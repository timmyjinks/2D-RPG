package com.neumont.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationHandler {
    private Texture texture;
    private int rows, columns, frameCount;
    private String filePath;
    private float frameDuration;
    private Animation<TextureRegion> animated;

    public AnimationHandler(int rows, int columns, int frameCount, String filePath, float frameDuration) {
        this.rows = rows;
        this.columns = columns;
        this.frameCount = frameCount;
        this.filePath = filePath;
        this.frameDuration = frameDuration;
    }

    public Animation<TextureRegion> animate(){
        texture = new Texture(filePath);
        TextureRegion[][] tmpFrames = TextureRegion.split(texture, texture.getWidth() / columns, texture.getHeight() / rows);
        TextureRegion[] animationFrames = new TextureRegion[frameCount];
        int frames = 0;
        for (int rows = 0; rows < this.rows; rows++){
            for (int columns = 0; columns < this.columns; columns++){
                animationFrames[frames++] = tmpFrames[rows][columns];
            }
        }
        animated = new Animation<>(frameDuration, animationFrames);
        return animated;
    }

//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//    elapsedTime += Gdx.graphics.getDeltaTime();
//		batch.begin();
//		batch.draw(skeletonIdle.getKeyFrame(elapsedTime, true), 1500f, 500f);
//		batch.draw(skeletonIdle.getKeyFrame(elapsedTime,true), 1000f, 500f);

}
