package edu.sandwichproductions.controller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationHandler {
//    private Texture texture;
//    private int rows, columns, frameCount;
//    private String filePath;
//    private float frameDuration;
//    private Animation<TextureRegion> animated;

    public static Animation<TextureRegion> animate(String filePath, int columns, int rows, int frameCount, float frameDuration){
        Texture texture = new Texture(filePath);
        TextureRegion[][] tmpFrames = TextureRegion.split(texture, texture.getWidth() / columns, texture.getHeight() / rows);
        TextureRegion[] animationFrames = new TextureRegion[frameCount];
        int frames = 0;
        for (int rowsI = 0; rowsI < rows - 1; rows++){
            for (int columnsI = 0; columnsI < columns - 1; columns++){
                animationFrames[frames++] = tmpFrames[rows][columns];
            }
        }
         return new Animation<TextureRegion>(frameDuration, animationFrames);
    }

//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//    elapsedTime += Gdx.graphics.getDeltaTime();
//		batch.begin();
//		batch.draw(skeletonIdle.getKeyFrame(elapsedTime, true), 1500f, 500f);
//		batch.draw(skeletonIdle.getKeyFrame(elapsedTime,true), 1000f, 500f);

}
